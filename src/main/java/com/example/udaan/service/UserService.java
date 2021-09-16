package com.example.udaan.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.udaan.dto.AdminRegistrationResponse;
import com.example.udaan.dto.AssessmentRequestDto;
import com.example.udaan.dto.AssessmentResponseDto;
import com.example.udaan.dto.RegistrationDto;
import com.example.udaan.dto.UserRegistrationResponse;
import com.example.udaan.entity.Admin;
import com.example.udaan.entity.User;
import com.example.udaan.repository.AdminRepository;
import com.example.udaan.repository.UserRepository;

import exception.InsertionException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AdminRepository adminRepository;

	public UserRegistrationResponse registerUser(RegistrationDto registrationDto) {
		User user = new User(registrationDto.getName(), registrationDto.getPhoneNumber(), registrationDto.getPinCode());
		user = userRepository.save(user);
		if(user == null || user.getId() == null) {
			throw new InsertionException("USER_INSERTION_FAILED");
		}
		return new UserRegistrationResponse(user.getId());
	}

	public AdminRegistrationResponse registerAdmin(RegistrationDto registrationDto) {
		Admin admin = new Admin(registrationDto.getName(), registrationDto.getPhoneNumber(),
				registrationDto.getPinCode());
		admin = adminRepository.save(admin);
		if(admin == null || admin.getId() == null) {
			throw new InsertionException("ADMIN_INSERTION_FAILED");
		}
		return new AdminRegistrationResponse(admin.getId());
	}

	public AssessmentResponseDto calculateAssessment(AssessmentRequestDto inputDto) {
		Optional<User> optUser = userRepository.findById(inputDto.getUserId());
		if(!optUser.isPresent()) {
			throw new EntityNotFoundException("USER_NOT_FOUND");
		}
	
		AssessmentResponseDto responseDto = new AssessmentResponseDto();
		if(inputDto.getSymptoms().isEmpty() && !inputDto.getContactWithCovidPatient() && !inputDto.getTravelHistory()) {
			responseDto.setRiskPercentage(5f);
		} else if (inputDto.getSymptoms().size() == 1 && (inputDto.getContactWithCovidPatient() || inputDto.getTravelHistory())) {
			responseDto.setRiskPercentage(50f);
		} else if(inputDto.getSymptoms().size() == 2 && (inputDto.getContactWithCovidPatient() || inputDto.getTravelHistory())) {
			responseDto.setRiskPercentage(75f);
		} else if(inputDto.getSymptoms().size() > 2 && (inputDto.getContactWithCovidPatient() || inputDto.getTravelHistory())) {
			responseDto.setRiskPercentage(95f);
		}

		return responseDto;
	}

}
