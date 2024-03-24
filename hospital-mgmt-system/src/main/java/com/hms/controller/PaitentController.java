package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.PaitentDaoImpl;
import com.hms.pojo.PaitentSignUpRequest;
import com.hms.pojo.PaitentSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaitentController {

	@Autowired
	private PaitentDaoImpl daoImpl;

	@PostMapping("/hms/paitent/signUp")
	public ResponseEntity<PaitentSignUpResponse> paitentSingup(@RequestBody PaitentSignUpRequest request) {

		log.info("Paitent Singup :  Request Recieved {} ", request.toString());
		
		if (request.getFirstName() == null || request.getFirstName().isBlank() || request.getLastName() == null ||
				request.getLastName().isBlank() || request.getEmail() == null || request.getEmail().isBlank() ||
				request.getAppointmentNo() == null || request.getContactInfo() == null) {
			
			PaitentSignUpResponse response = new PaitentSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<PaitentSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		PaitentSignUpResponse response = daoImpl.paitentSignUp(request);

		return new ResponseEntity<PaitentSignUpResponse>(response, HttpStatus.OK);
		
//		try {
//			PaitentSignUpResponse response = daoImpl.paitentSignUp(request);
//			return new ResponseEntity<PaitentSignUpResponse>(response, HttpStatus.OK);
//		} catch (DataIntegrityViolationException e) {
//			PaitentSignUpResponse errorResponse = new PaitentSignUpResponse();
//			errorResponse.setCode(HttpStatus.CONFLICT.name());
//			errorResponse.setMessage("Duplicate appointment number");
//			return new ResponseEntity<PaitentSignUpResponse>(errorResponse, HttpStatus.CONFLICT);
//		}
	}
	
}
