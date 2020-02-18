package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {
	@RequestMapping("/user/{userid}")	
	public UserRating getRating(@PathVariable("userid")String userId)
	{
		List <Rating> ratings=Arrays.asList
				(new Rating("123",4),
				 new Rating("1234",5));
		UserRating userRating=new UserRating();
		userRating.setUserrating(ratings);
		return userRating;
	}

}
