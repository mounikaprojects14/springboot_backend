package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.DoctorModel;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
 
	
}
