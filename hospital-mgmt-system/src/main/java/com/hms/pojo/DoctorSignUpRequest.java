package com.hms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSignUpRequest {

	private String firstName;
	
	private String lastName;
	
	private String specalizedIn;
	
	private String contactInfo;
}
