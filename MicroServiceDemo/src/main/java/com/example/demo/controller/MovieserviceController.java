package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CatalogItems;
import com.example.demo.model.TestSettings;
import com.example.demo.model.UserRating;
import com.example.demo.service.MovieInfo;
import com.example.demo.service.UserRratingInfo;
@RefreshScope
@RestController
@RequestMapping("/catalog")
public class MovieserviceController {
@Value("${test.value}")	
private String testData;	

@Value("${test.list}")
private List<String> name;

@Value("${test.num:default value}")	
private String testDflt;	

@Value("#{${test.map}}")
private Map<String,String> testmap;
@Autowired
private TestSettings testSettings;

@Autowired	
RestTemplate restTemplate;

@Autowired
MovieInfo movieinfo;

@Autowired
UserRratingInfo userRatinginfo;
@Autowired
private Environment env;


	@RequestMapping("/{userId}")	
	public List<CatalogItems> getCatalogItems(@PathVariable("userId")String userId)
	{
		
		
		//RestTemplate restTemplate=new RestTemplate();
		
		UserRating ratings=userRatinginfo.getUserRating(userId);
		return ratings.getUserrating().stream().map(rating->
		movieinfo.getMovie(rating)).collect(Collectors.toList());
		
	}
	
	@RequestMapping("/test")	
	public String getTestData()
	{
		
		
		//RestTemplate restTemplate=new RestTemplate();
		
		return testData+":"+testSettings.getCount();
		
	}
	@GetMapping("/testSettings")
	public String getTestSettings()
	{
		return testSettings.getMap()+" "+testSettings.getCount() + " "+testSettings.getList()+" "+testSettings.getValue();
	}
	
	@GetMapping("/envDetails")
	public String getEnvDetails()
	{
		return env.toString();
	}
	
	
	}
