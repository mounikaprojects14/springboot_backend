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
@Table(name = "Insurance")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InsuranceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long InsuranceId;
	
	@Column // ForeignKey
	private Long PatientId;

	@Column
	private String PolicyNumber; 
	
	@Column
	private String CoverageLimits;
	
	@Column
	private String InsuranceCompany;
	
	@Column
	private String PaymentStatus;
	
	@Column
	private Date PolicyStartDate;
	
	@Column
	private Date PolicyEndDate;
	
	

}
