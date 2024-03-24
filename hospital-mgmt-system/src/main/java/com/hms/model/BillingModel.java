package com.hms.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Billing")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BillingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long BillId;
	
	@Column // ForeignKey
	private Long PatientId;
	
	@Column
	private Long Amount; //datatype decimal
	
	@Column
	private Date BillingDate;
	
	@Column
	private String PaymentStatus;
	

}
