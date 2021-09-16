package com.example.udaan.dto;

public class UserRegistrationResponse {

	private Integer userId;

	public UserRegistrationResponse(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
