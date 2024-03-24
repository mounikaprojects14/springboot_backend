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
@Table(name = "Wards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WardsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long RoomNo;
	
	@Column // ForeignKey
	private Long PatientId;

	@Column
	private String Ward; 
	
	@Column
	private Long BedCount;
		
	@Column
	private Boolean Availability;
	
	@Column
	private String OccupancyStatus;
	

}
