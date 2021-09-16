package com.example.udaan.dto;

public class AssessmentResponseDto {

	private Float riskPercentage;

	public AssessmentResponseDto() {
	}
	
	public AssessmentResponseDto(Float riskPercentage) {
		super();
		this.riskPercentage = riskPercentage;
	}

	public Float getRiskPercentage() {
		return riskPercentage;
	}

	public void setRiskPercentage(Float riskPercentage) {
		this.riskPercentage = riskPercentage;
	}
	
}
