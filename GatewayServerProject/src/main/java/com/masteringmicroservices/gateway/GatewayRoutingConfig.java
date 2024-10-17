package com.masteringmicroservices.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class GatewayRoutingConfig {

	public RouteLocator locator;
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route("MASTERING-MICROSERVICE", p -> p
	            .path("/orders/**")
	            .filters(f -> f.requestRateLimiter(c-> c.setRateLimiter(redisRateLimiter())))
	            .uri("lb://MASTERING-MICROSERVICE"))
	        .build();
	}
	
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(10,20);
	}
	
}
