package com.example.demo.model;

import java.util.List;

public class UserRating {
	
	private String userId;
	private List<Rating> userrating;
	
	

	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Rating> getUserrating() {
		return userrating;
	}

	public void setUserrating(List<Rating> userrating) {
		this.userrating = userrating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
