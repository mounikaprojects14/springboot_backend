package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.PrescriptionsModel;

@Repository
public interface PrescriptionsRepository extends JpaRepository<PrescriptionsModel, Long> {
 
	
}
