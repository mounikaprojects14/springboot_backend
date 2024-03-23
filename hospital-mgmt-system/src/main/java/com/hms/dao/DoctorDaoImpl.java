package com.hms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.model.DoctorModel;
import com.hms.pojo.DoctorSignUpRequest;
import com.hms.pojo.DoctorSignUpResponse;
import com.hms.repository.DoctorRepository;

@Service
public class DoctorDaoImpl {

	@Autowired
	private DoctorRepository doctorRepository;

	public DoctorSignUpResponse doctorSignUp(DoctorSignUpRequest request) {
		DoctorModel model = new DoctorModel();
		model.setFirstName(request.getFirstName());
		model.setLastName(request.getLastName());
		model.setSpecalizedIn(request.getSpecalizedIn());
		model.setContactInfo(request.getContactInfo());
		
		DoctorModel response = doctorRepository.save(model);
		if (response != null) {
			DoctorSignUpResponse doctorSignUpResponse = new DoctorSignUpResponse();
			doctorSignUpResponse.setMessage("SignUp Successfull");
			doctorSignUpResponse.setFirstName(response.getFirstName());
			doctorSignUpResponse.setLastName(response.getLastName());
			doctorSignUpResponse.setSpecalizedIn(response.getSpecalizedIn());
			doctorSignUpResponse.setContactInfo(response.getContactInfo());
			

			return doctorSignUpResponse;
		}

		return null;
	}

}
