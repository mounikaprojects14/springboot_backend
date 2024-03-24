package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceSignUpRequest {
	
	private Long patientId; // FK
	
	private String policyNumber;
	
	private String coverageLimits;
	
	private String insuranceCompany; 
	
	private Date policyStartDate;
	
	private Date policyEndDate;
}
