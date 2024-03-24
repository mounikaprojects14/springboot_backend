package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersSignUpRequest {
	
	private String supplierName; 
	
	private String contactInformation; 
	
	private String productCatalog;
	
}
