package com.masteringmicroservices.eureka.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
