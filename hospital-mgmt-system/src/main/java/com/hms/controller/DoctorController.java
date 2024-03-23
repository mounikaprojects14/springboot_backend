package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.DoctorDaoImpl;
import com.hms.pojo.DoctorSignUpRequest;
import com.hms.pojo.DoctorSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DoctorController {

	@Autowired
	private DoctorDaoImpl daoImpl;

	@PostMapping("/hms/doctor/signUp")
	public ResponseEntity<DoctorSignUpResponse> doctorSingup(@RequestBody DoctorSignUpRequest request) {

		log.info("Doctor Singup :  Request Recieved {} ", request.toString());
		
		if (request.getFirstName() == null || request.getFirstName().isBlank() || request.getLastName() == null ||
				request.getLastName().isBlank()) {
			
			DoctorSignUpResponse response = new DoctorSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<DoctorSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		DoctorSignUpResponse response = daoImpl.doctorSignUp(request);

		return new ResponseEntity<DoctorSignUpResponse>(response, HttpStatus.OK);
	}
}
