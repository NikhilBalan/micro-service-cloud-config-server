package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroServiceDemo1Application {
	
	@Bean
	public RestTemplate GETtEMPLATE()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceDemo1Application.class, args);
	}

}
