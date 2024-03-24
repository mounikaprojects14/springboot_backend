package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaitentSignUpRequest {
	
	private String firstName;
	
	private String lastName;
	
	private Long contactInfo;
	
	private Date bornDate;
	
	private String gender;
	
	private String email;
	
	private Integer appointmentNo;
	
	private String city;
}
