package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardsSignUpResponse {

	private String message;
	private String code;
	private Long PatientId; // FK
	private String Ward; 
	private Long BedCount; 
	private Boolean Availability;
	private String OccupancyStatus;

}
