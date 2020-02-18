package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MicroServiceDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceDemoApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	
	public RestTemplate getRestTemplate()
	{
		HttpComponentsClientHttpRequestFactory clientrequestFact= new HttpComponentsClientHttpRequestFactory();
		clientrequestFact.setConnectTimeout(3000);
		return new RestTemplate(clientrequestFact);
		
	}

	

}
