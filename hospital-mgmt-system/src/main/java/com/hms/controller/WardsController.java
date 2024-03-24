package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.WardsDaoImpl;
import com.hms.pojo.WardsSignUpRequest;
import com.hms.pojo.WardsSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WardsController {

	@Autowired
	private WardsDaoImpl daoImpl;

	@PostMapping("/hms/wards/signUp")
	public ResponseEntity<WardsSignUpResponse> wardsSingup(@RequestBody WardsSignUpRequest request) {

		log.info("Wards Singup :  Request Recieved {} ", request.toString());
		
		if (request.getWard() == null || request.getWard().isBlank() || request.getBedCount() == null || 
				request.getAvailability() == null ||
				request.getOccupancyStatus() == null || request.getOccupancyStatus().isBlank()) {
			
			WardsSignUpResponse response = new WardsSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<WardsSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		WardsSignUpResponse response = daoImpl.wardsSignUp(request);

		return new ResponseEntity<WardsSignUpResponse>(response, HttpStatus.OK);
	}
}
