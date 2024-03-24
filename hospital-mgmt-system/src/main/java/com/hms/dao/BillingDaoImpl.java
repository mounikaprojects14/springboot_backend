package com.hms.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hms.model.BillingModel;
import com.hms.pojo.BillingSignUpRequest;
import com.hms.pojo.BillingSignUpResponse;
import com.hms.repository.BillingRepository;

@Service
public class BillingDaoImpl {

	@Autowired
	private BillingRepository billingRepository;

	public BillingSignUpResponse billingSignUp(BillingSignUpRequest request) {
		BillingModel model = new BillingModel();
//		model.setPatientId(request.getPatientId()); //FK
		model.setPaymentStatus(request.getPaymentStatus());
		model.setAmount(request.getAmount()); 
		model.setBillingDate(request.getBillingDate());

		BillingModel response = billingRepository.save(model);
		if (response != null) {
			BillingSignUpResponse billingSignUpResponse = new BillingSignUpResponse();
			billingSignUpResponse.setMessage("SignUp Successfull");
			billingSignUpResponse.setPaymentStatus(response.getPaymentStatus());
			billingSignUpResponse.setAmount(response.getAmount());
			billingSignUpResponse.setBillingDate(response.getBillingDate());

			return billingSignUpResponse;
		}


		return null;
	}


}
