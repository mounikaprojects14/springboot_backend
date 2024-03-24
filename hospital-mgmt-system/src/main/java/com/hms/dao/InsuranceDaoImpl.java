package com.hms.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.hms.model.InsuranceModel;
import com.hms.pojo.InsuranceSignUpRequest;
import com.hms.pojo.InsuranceSignUpResponse;
import com.hms.repository.InsuranceRepository;

@Service
public class InsuranceDaoImpl {

	@Autowired
	private InsuranceRepository insuranceRepository;

	public InsuranceSignUpResponse insuranceSignUp(InsuranceSignUpRequest request) {
		InsuranceModel model = new InsuranceModel();
//		model.setPatientId(request.getPatientId()); //FK
		model.setPolicyNumber(request.getPolicyNumber());
		model.setCoverageLimits(request.getCoverageLimits()); 
		model.setInsuranceCompany(request.getInsuranceCompany());
		model.setPolicyStartDate(request.getPolicyStartDate()); 
		model.setPolicyEndDate(request.getPolicyEndDate());


		InsuranceModel response = insuranceRepository.save(model);
		if (response != null) {
			InsuranceSignUpResponse insuranceSignUpResponse = new InsuranceSignUpResponse();
			insuranceSignUpResponse.setPolicyNumber(request.getPolicyNumber());
			insuranceSignUpResponse.setCoverageLimits(request.getCoverageLimits()); 
			insuranceSignUpResponse.setInsuranceCompany(request.getInsuranceCompany());
			insuranceSignUpResponse.setPolicyStartDate(request.getPolicyStartDate()); 
			insuranceSignUpResponse.setPolicyEndDate(request.getPolicyEndDate());

			return insuranceSignUpResponse;
		}


		return null;
	}


}
