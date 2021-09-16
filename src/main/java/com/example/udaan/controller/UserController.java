package com.example.udaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.udaan.dto.AssessmentRequestDto;
import com.example.udaan.dto.AssessmentResponseDto;
import com.example.udaan.dto.RegistrationDto;
import com.example.udaan.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<Object> register(@RequestBody @Valid RegistrationDto inputDto, @RequestParam String type) {
		if (type == null || type.equals("USER")) {
			return new ResponseEntity<Object>(userService.registerUser(inputDto), HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(userService.registerAdmin(inputDto), HttpStatus.CREATED);

	}

	@GetMapping(value = "/assessment")
	public ResponseEntity<AssessmentResponseDto> selfAssessment(@RequestBody @Valid AssessmentRequestDto inputDto) {
		return new ResponseEntity<AssessmentResponseDto>(userService.calculateAssessment(inputDto), HttpStatus.OK);
	}
}
