package com.hms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.model.MedicalRecordModel;
import com.hms.pojo.MedicalRecordSignUpRequest;
import com.hms.pojo.MedicalRecordSignUpResponse;
import com.hms.repository.MedicalRecordRepository; 

@Service
public class MedicalRecordDaoImpl {

	@Autowired
	private MedicalRecordRepository medicalrecordRepository;

	public MedicalRecordSignUpResponse medicalrecordSignUp(MedicalRecordSignUpRequest request) {
		MedicalRecordModel model = new MedicalRecordModel();
		model.setDiagnosis(request.getDiagnosis());
		model.setMedications(request.getMedications());
		model.setTestResults(request.getTestResults());
		model.setTreatment(request.getTreatment());
		model.setDate(request.getDate());
		
		MedicalRecordModel response = medicalrecordRepository.save(model);
		if (response != null) {
			MedicalRecordSignUpResponse medicalrecordSignUpResponse = new MedicalRecordSignUpResponse();
			medicalrecordSignUpResponse.setDiagnosis(request.getDiagnosis());
			medicalrecordSignUpResponse.setMedications(request.getMedications());
			medicalrecordSignUpResponse.setTestResults(request.getTestResults());
			medicalrecordSignUpResponse.setTreatment(request.getTreatment());
			medicalrecordSignUpResponse.setDate(request.getDate());
			

			return medicalrecordSignUpResponse;
		}

		return null;
	}

}
