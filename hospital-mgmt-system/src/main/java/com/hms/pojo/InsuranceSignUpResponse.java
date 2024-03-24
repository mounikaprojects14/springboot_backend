package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceSignUpResponse {

	private String message;
	private String code;
	private Long PatientId; // FK
	private String PolicyNumber;
	private String CoverageLimits;
	private String InsuranceCompany; 
	private Date PolicyStartDate;
	private Date PolicyEndDate;
	
}
