package com.example.udaan.dto;

import javax.validation.constraints.NotNull;

public class RegistrationDto {

	@NotNull
	private String name;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String pinCode;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
