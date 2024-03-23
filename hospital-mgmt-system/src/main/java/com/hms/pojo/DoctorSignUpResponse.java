package com.hms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSignUpResponse {

	private String message;
	private String code;
	private String FirstName;
	private String LastName;
	private String SpecalizedIn;
	private String ContactInfo;
}
