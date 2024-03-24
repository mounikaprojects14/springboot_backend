package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionsSignUpRequest {
	
	private Long patientId; // FK
	
	private Long doctorId;  // FK
	
	private String medication;
	
	private String dosage; 
	
	private Date datePrescribed;
	
}
