package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.BillingDaoImpl;
import com.hms.pojo.BillingSignUpRequest;
import com.hms.pojo.BillingSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BillingController {

	@Autowired
	private BillingDaoImpl daoImpl;

	@PostMapping("/hms/billing/signUp")
	public ResponseEntity<BillingSignUpResponse> billingSingup(@RequestBody BillingSignUpRequest request) {

		log.info("Billing Singup :  Request Recieved {} ", request.toString());
		
		if (request.getBillingDate() == null || request.getPaymentStatus() == null ||
				request.getPaymentStatus().isBlank()) {
			
			BillingSignUpResponse response = new BillingSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<BillingSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		BillingSignUpResponse response = daoImpl.billingSignUp(request);

		return new ResponseEntity<BillingSignUpResponse>(response, HttpStatus.OK);
	}
}
