package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.BillingModel;

@Repository
public interface BillingRepository extends JpaRepository<BillingModel, Long> {
 
	
}
