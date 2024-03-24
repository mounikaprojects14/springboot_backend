package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.AppointmentsDaoImpl;
import com.hms.pojo.AppointmentsSignUpRequest;
import com.hms.pojo.AppointmentsSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppointmentsController {

	@Autowired
	private AppointmentsDaoImpl daoImpl;

	@PostMapping("/hms/appointment/signUp")
	public ResponseEntity<AppointmentsSignUpResponse> appointmentsSingup(@RequestBody AppointmentsSignUpRequest request) {

		log.info("Appointments Singup :  Request Recieved {} ", request.toString());
		
		if (request.getAppointmentDate() == null || request.getSchedule() == null ||
				request.getSchedule().isBlank()) {
			
			AppointmentsSignUpResponse response = new AppointmentsSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<AppointmentsSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		AppointmentsSignUpResponse response = daoImpl.appointmentsSignUp(request);

		return new ResponseEntity<AppointmentsSignUpResponse>(response, HttpStatus.OK);
	}
}
