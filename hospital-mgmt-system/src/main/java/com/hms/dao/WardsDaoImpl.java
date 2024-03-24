package com.hms.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.model.WardsModel;
import com.hms.pojo.WardsSignUpRequest;
import com.hms.pojo.WardsSignUpResponse;
import com.hms.repository.WardsRepository;

@Service
public class WardsDaoImpl {

	@Autowired
	private WardsRepository wardsRepository;

	public WardsSignUpResponse wardsSignUp(WardsSignUpRequest request) {
		WardsModel model = new WardsModel();
//		model.setPatientId(request.getPatientId()); // FK
		model.setWard(request.getWard());
		model.setBedCount(request.getBedCount());
		model.setAvailability(request.getAvailability());
		model.setOccupancyStatus(request.getOccupancyStatus());

		
		WardsModel response = wardsRepository.save(model);
		if (response != null) {
			WardsSignUpResponse wardsSignUpResponse = new WardsSignUpResponse();
			wardsSignUpResponse.setMessage("SignUp Successfull");
//			wardsSignUpResponse.setPatientId(request.getPatientId()); // FK
			wardsSignUpResponse.setWard(response.getWard());
			wardsSignUpResponse.setBedCount(response.getBedCount());
			wardsSignUpResponse.setAvailability(response.getAvailability());
			wardsSignUpResponse.setOccupancyStatus(response.getOccupancyStatus());

			return wardsSignUpResponse;
		}


		return null;
	}


}
