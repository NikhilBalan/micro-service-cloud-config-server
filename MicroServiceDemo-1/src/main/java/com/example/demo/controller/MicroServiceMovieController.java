package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MicroServiceMovieController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")	
	public Movie getMovie(@PathVariable("movieId")String movieId)
	{
	return new Movie(movieId,"terminator","action genre");
	}

}
