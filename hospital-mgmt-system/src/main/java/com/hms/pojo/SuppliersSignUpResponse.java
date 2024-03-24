package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersSignUpResponse {

	private String message;
	private String code;
	private String SupplierName; 
	private String ContactInformation; 
	private String ProductCatalog;

}
