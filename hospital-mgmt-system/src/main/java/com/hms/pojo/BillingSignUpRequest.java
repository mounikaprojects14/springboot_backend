package com.hms.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingSignUpRequest {
	
	private Long patientId; // FK
	
	private String paymentStatus;
	
	private Long Amount; //Decimal DT
	
	private String PaymentStatus;
	
	private Date BillingDate;
	
}
