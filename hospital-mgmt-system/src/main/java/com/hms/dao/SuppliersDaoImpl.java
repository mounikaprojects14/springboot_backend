package com.hms.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.model.SuppliersModel;
import com.hms.pojo.SuppliersSignUpRequest;
import com.hms.pojo.SuppliersSignUpResponse;
import com.hms.repository.SuppliersRepository;

@Service
public class SuppliersDaoImpl {

	@Autowired
	private SuppliersRepository suppliersRepository;

	public SuppliersSignUpResponse suppliersSignUp(SuppliersSignUpRequest request) {
		SuppliersModel model = new SuppliersModel();
		model.setSupplierName(request.getSupplierName());
		model.setContactInformation(request.getContactInformation());
		model.setProductCatalog(request.getProductCatalog());

		
		SuppliersModel response = suppliersRepository.save(model);
		if (response != null) {
			SuppliersSignUpResponse suppliersSignUpResponse = new SuppliersSignUpResponse();
			suppliersSignUpResponse.setMessage("SignUp Successfull");
			suppliersSignUpResponse.setSupplierName(response.getSupplierName());
			suppliersSignUpResponse.setContactInformation(response.getContactInformation());
			suppliersSignUpResponse.setProductCatalog(response.getProductCatalog());

			return suppliersSignUpResponse;
		}


		return null;
	}


}
