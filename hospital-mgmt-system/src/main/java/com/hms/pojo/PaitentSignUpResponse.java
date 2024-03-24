package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaitentSignUpResponse {

	private String message;
	private String code;
	private String FirstName;
	private String LastName;
	private Long contactInfo;
	private Date bornDate;
	private String gender;
	private String email;
	private Integer appointmentNo;
	private String city;
}
