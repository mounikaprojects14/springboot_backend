package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.MedicalRecordDaoImpl;
import com.hms.pojo.MedicalRecordSignUpRequest;
import com.hms.pojo.MedicalRecordSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MedicalRecordController {

	@Autowired
	private MedicalRecordDaoImpl daoImpl;

	@PostMapping("/hms/medicalrecord/signUp")
	public ResponseEntity<MedicalRecordSignUpResponse> medicalrecordSingup(@RequestBody MedicalRecordSignUpRequest request) {

		log.info("MedicalRecord Singup :  Request Recieved {} ", request.toString());
		
		if (request.getDiagnosis() == null || request.getDiagnosis().isBlank() || request.getDate() == null ||
				request.getTreatment() == null || request.getDiagnosis().isBlank() ||
				request.getMedications() == null || request.getMedications().isBlank() ||
				request.getTestResults() == null || request.getTestResults().isBlank() ) {
			
			MedicalRecordSignUpResponse response = new MedicalRecordSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<MedicalRecordSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		MedicalRecordSignUpResponse response = daoImpl.medicalrecordSignUp(request);

		return new ResponseEntity<MedicalRecordSignUpResponse>(response, HttpStatus.OK);
	}
}
