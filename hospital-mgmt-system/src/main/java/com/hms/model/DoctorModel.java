package com.hms.model;

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
@Table(name = "Doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DoctorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long DoctorId;

	@Column //@Column(unique = true)
	private String FirstName;
	
	@Column
	private String LastName;
	
	@Column
	private String SpecalizedIn;
	
	@Column
	private String ContactInfo;
	

}
