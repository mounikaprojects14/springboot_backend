package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.PrescriptionsDaoImpl;
import com.hms.pojo.PrescriptionsSignUpRequest;
import com.hms.pojo.PrescriptionsSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PrescriptionsController {

	@Autowired
	private PrescriptionsDaoImpl daoImpl;

	@PostMapping("/hms/prescriptions/signUp")
	public ResponseEntity<PrescriptionsSignUpResponse> prescriptionsSingup(@RequestBody PrescriptionsSignUpRequest request) {

		log.info("Prescriptions Singup :  Request Recieved {} ", request.toString());
		
		if (request.getMedication() == null || request.getMedication().isBlank() || request.getDosage() == null ||
				request.getDosage().isBlank() || request.getDatePrescribed() == null) {
			PrescriptionsSignUpResponse response = new PrescriptionsSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<PrescriptionsSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		PrescriptionsSignUpResponse response = daoImpl.prescriptionsSignUp(request);

		return new ResponseEntity<PrescriptionsSignUpResponse>(response, HttpStatus.OK);
	}
}
