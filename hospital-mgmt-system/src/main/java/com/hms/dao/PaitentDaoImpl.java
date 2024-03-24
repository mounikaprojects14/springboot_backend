package com.hms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hms.model.PaitentModel;
import com.hms.pojo.PaitentSignUpRequest;
import com.hms.pojo.PaitentSignUpResponse;
import com.hms.repository.PaitentRepository;

@Service
public class PaitentDaoImpl {

	@Autowired
	private PaitentRepository paitentRepository;

	public PaitentSignUpResponse paitentSignUp(PaitentSignUpRequest request) {
		PaitentModel model = new PaitentModel();
		model.setFirstName(request.getFirstName());
		model.setLastName(request.getLastName());
		model.setContactInfo(request.getContactInfo());
		model.setBornDate(request.getBornDate());
		model.setGender(request.getGender());
		model.setAppointmentNo(request.getAppointmentNo());
		model.setCity(request.getCity());
		model.setEmail(request.getEmail());

//		try {
		PaitentModel response = paitentRepository.save(model);
		if (response != null) {
			PaitentSignUpResponse paitentSignUpResponse = new PaitentSignUpResponse();
			paitentSignUpResponse.setMessage("SignUp Successfull");
			paitentSignUpResponse.setFirstName(response.getFirstName());
			paitentSignUpResponse.setLastName(response.getLastName());
			paitentSignUpResponse.setContactInfo(response.getContactInfo());
			paitentSignUpResponse.setBornDate(response.getBornDate());
			paitentSignUpResponse.setGender(response.getGender());
			paitentSignUpResponse.setAppointmentNo(response.getAppointmentNo());
			paitentSignUpResponse.setCity(response.getCity());
			paitentSignUpResponse.setEmail(response.getEmail());

			return paitentSignUpResponse;
		}
//
//		} catch (DataIntegrityViolationException e) {
//			// Handle duplicate appointment number exception here
//			// You can throw custom exception or return an error response
//			// For now, I'm returning a response indicating failure due to duplicate appointment number
//			PaitentSignUpResponse errorResponse = new PaitentSignUpResponse();
//			errorResponse.setMessage("SignUp Failed: Duplicate appointment number");
//			return errorResponse;
//		}

		return null;
	}


}
