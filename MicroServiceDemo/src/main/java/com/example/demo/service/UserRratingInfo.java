package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service 
public class UserRratingInfo {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallBackRating")
	public UserRating getUserRating(@PathVariable("userId")String userId) {
		return restTemplate.getForObject(
				"http://Micro-Service-Demo2/rating/user/"+userId, UserRating.class);
	}
public UserRating getFallBackRating(@PathVariable("userId")String userId) {
		
		UserRating tempRating= new UserRating();
		tempRating.setUserId(userId);
		tempRating.setUserrating(Arrays.asList(new Rating("0",0)));
		return tempRating;
	}	

}
