package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.SuppliersDaoImpl;
import com.hms.pojo.SuppliersSignUpRequest;
import com.hms.pojo.SuppliersSignUpResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SuppliersController {

	@Autowired
	private SuppliersDaoImpl daoImpl;

	@PostMapping("/hms/billing/signUp")
	public ResponseEntity<SuppliersSignUpResponse> suppliersSingup(@RequestBody SuppliersSignUpRequest request) {

		log.info("Suppliers Singup :  Request Recieved {} ", request.toString());
		
		if (request.getSupplierName() == null || request.getSupplierName() == null ||
			 request.getContactInformation() ==  null || request.getContactInformation().isBlank() ||
			 request.getProductCatalog() ==  null || request.getProductCatalog().isBlank()) {
		
			SuppliersSignUpResponse response = new SuppliersSignUpResponse();
			response.setCode(HttpStatus.BAD_REQUEST.name());
			response.setMessage("Invalid Parameters Values cannot be NULL or EMPTY");
			return new ResponseEntity<SuppliersSignUpResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		SuppliersSignUpResponse response = daoImpl.suppliersSignUp(request);

		return new ResponseEntity<SuppliersSignUpResponse>(response, HttpStatus.OK);
	}
}
