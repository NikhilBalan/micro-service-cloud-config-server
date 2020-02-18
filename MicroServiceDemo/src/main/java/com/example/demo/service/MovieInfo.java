package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CatalogItems;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfo {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallBackCatalog",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50" ),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")}
			
	)
	public CatalogItems getMovie(Rating rating) {
		System.out.println("user id::"+rating.getUserId());
		 Movie movie=restTemplate.getForObject("http://Micro-Service-Demo1/movies/"+rating.getUserId(), Movie.class);
		 System.out.println("movie name::"+movie.getName());
		 return new CatalogItems(movie.getName(), movie.getDesc(), rating.getRating());
	}
	
	public CatalogItems getFallBackCatalog(Rating rating)
	{
		System.out.println("inside f");
		return new CatalogItems("no movie", "NA",0);
	}

}
