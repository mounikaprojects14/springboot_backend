package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingSignUpResponse {

	private String message;
	private String code;
    private Long PatientId; // FK
	private String PaymentStatus;
	private Long Amount; //Decimal DT
	private Date BillingDate;
	
}
