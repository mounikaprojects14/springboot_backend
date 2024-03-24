package com.hms.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Paitent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaitentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paitent_seq")
//	@SequenceGenerator(sequenceName = "paitent_seq", allocationSize = 1, name = "paitent_seq")
	private Long PaitentId;
	
	@Column
	private String FirstName;
	
	@Column
	private String LastName;
	
	@Column
	private Long ContactInfo;
	
	@Column
	private Date BornDate;
	
	
	@Column
	private String Gender;
	
	@Column
	private String Email;
	
	@Column(unique = true)
	private Integer AppointmentNo;
	
	private String city;
	
//	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // mappedBy refers to the field name in MedicalRecordModel
//    private List<MedicalRecordModel> medicalRecords;
}