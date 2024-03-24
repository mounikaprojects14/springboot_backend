package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.PaitentModel;

@Repository
public interface PaitentRepository extends JpaRepository<PaitentModel, Long> {
 
	
}
