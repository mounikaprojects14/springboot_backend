package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordSignUpRequest {

	private String diagnosis;
	
	private String treatment;
	
	private String medications;
	
	private String testResults;
	
	private Date date;
}
