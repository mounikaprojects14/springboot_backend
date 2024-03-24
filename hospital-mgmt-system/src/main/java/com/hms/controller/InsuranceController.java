package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.InsuranceDaoImpl;
import com.hms.pojo.InsuranceSignUpRequest;
import com.hms.pojo.InsuranceSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InsuranceController {

	@Autowired
	private InsuranceDaoImpl daoImpl;

	@PostMapping("/hms/insurance/signUp")
	public ResponseEntity<InsuranceSignUpResponse> insuranceSingup(@RequestBody InsuranceSignUpRequest request) {

		log.info("Insurance Singup :  Request Recieved {} ", request.toString());
		
		if (request.getPolicyNumber() == null || request.getPolicyNumber().isBlank() || request.getCoverageLimits() == null ||
				request.getCoverageLimits().isBlank() || request.getInsuranceCompany() == null ||
				request.getPolicyStartDate() == null || request.getPolicyEndDate() == null ) {
			
			InsuranceSignUpResponse response = new InsuranceSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<InsuranceSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		InsuranceSignUpResponse response = daoImpl.insuranceSignUp(request);

		return new ResponseEntity<InsuranceSignUpResponse>(response, HttpStatus.OK);
	}
}
