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
@Table(name = "Appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AppointmentsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long AppointmentId;

	@Column // ForeignKey
	private Long DoctorId;
	
	@Column  // ForeignKey
	private Long PatientId;
	
	@Column
	private Date AppointmentDate;
	
	@Column
	private String Schedule;
	

}
