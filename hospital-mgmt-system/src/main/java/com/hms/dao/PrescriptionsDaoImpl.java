package com.hms.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hms.model.PrescriptionsModel;
import com.hms.pojo.PrescriptionsSignUpRequest;
import com.hms.pojo.PrescriptionsSignUpResponse;
import com.hms.repository.PrescriptionsRepository;

@Service
public class PrescriptionsDaoImpl {

	@Autowired
	private PrescriptionsRepository prescriptionsRepository;

	public PrescriptionsSignUpResponse prescriptionsSignUp(PrescriptionsSignUpRequest request) {
		PrescriptionsModel model = new PrescriptionsModel();
//		model.setDoctorId(request.getDoctorId()); //FK
//		model.setPatientId(request.getPatientId()); //FK
		model.setMedication(request.getMedication());
		model.setDosage(request.getDosage());
		model.setDatePrescribed(request.getDatePrescribed());

		
		PrescriptionsModel response = prescriptionsRepository.save(model);
		if (response != null) {
			PrescriptionsSignUpResponse prescriptionsSignUpResponse = new PrescriptionsSignUpResponse();
			prescriptionsSignUpResponse.setMessage("SignUp Successfull");
//			prescriptionsSignUpResponse.setDoctorId(request.getDoctorId()); //FK
//			prescriptionsSignUpResponse.setPatientId(request.getPatientId()); //FK
			prescriptionsSignUpResponse.setMedication(response.getMedication());
			prescriptionsSignUpResponse.setDosage(response.getDosage());
			prescriptionsSignUpResponse.setDatePrescribed(response.getDatePrescribed());

			return prescriptionsSignUpResponse;
		}


		return null;
	}


}
