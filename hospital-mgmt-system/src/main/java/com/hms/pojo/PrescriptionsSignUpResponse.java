package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionsSignUpResponse {

	private String message;
	private String code;
	private Long PatientId; // FK
	private Long DoctorId; // FK
	private String Medication;
	private String Dosage; 
	private Date DatePrescribed;

}
