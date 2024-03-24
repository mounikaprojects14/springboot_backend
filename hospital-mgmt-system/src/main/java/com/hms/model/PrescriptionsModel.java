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
@Table(name = "Prescriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PrescriptionsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long PrescriptionID;
	
	@Column // ForeignKey
	private Long PatientId;

	@Column // ForeignKey
	private Long DoctorId;

	@Column
	private String Medication; 
	
	@Column
	private String Dosage;
	
	@Column
	private Date DatePrescribed;	
	

}
