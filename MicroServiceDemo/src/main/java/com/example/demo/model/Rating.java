package com.example.demo.model;

public class Rating {
	
	private String userId;
	
	private int rating;

	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(String userId, int rating) {
		super();
		this.userId = userId;
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
