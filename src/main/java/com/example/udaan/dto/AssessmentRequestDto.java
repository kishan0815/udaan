package com.example.udaan.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class AssessmentRequestDto {

	@NotNull
	private Integer userId;
	
	@NotNull
	private List<String> symptoms;
	
	@NotNull
	private Boolean travelHistory;
	
	@NotNull
	private Boolean contactWithCovidPatient;

	public AssessmentRequestDto(Integer userId, List<String> symptoms, Boolean travelHistory,
			Boolean contactWithCovidPatient) {
		super();
		this.userId = userId;
		this.symptoms = symptoms;
		this.travelHistory = travelHistory;
		this.contactWithCovidPatient = contactWithCovidPatient;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public Boolean getTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(Boolean travelHistory) {
		this.travelHistory = travelHistory;
	}

	public Boolean getContactWithCovidPatient() {
		return contactWithCovidPatient;
	}

	public void setContactWithCovidPatient(Boolean contactWithCovidPatient) {
		this.contactWithCovidPatient = contactWithCovidPatient;
	}
	

}
