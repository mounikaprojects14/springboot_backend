package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentsSignUpResponse {

	private String message;
	private String code;
	private Long DoctorId; // FK
	private Long PatientId; // FK
	private String Schedule;
	private Date AppointmentDate;

}