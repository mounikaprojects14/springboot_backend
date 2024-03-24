package com.hms.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MedicalRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MedicalRecordModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long RecordId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PaitentId")
	private PaitentModel PaitentId;
	
	@Column //@Column(unique = true)
	private String diagnosis;
	
	@Column
	private String treatment;
	
	@Column
	private String medications;
	
	@Column
	private String testResults;
	
	@Column
	private Date date;
	

}
