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
@Table(name = "Suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SuppliersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long SupplierId;

	@Column
	private String SupplierName; 
	
	@Column
	private String ContactInformation;
	
	@Column
	private String ProductCatalog;

	
}
