package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.WardsModel;

@Repository
public interface WardsRepository extends JpaRepository<WardsModel, Long> {
 
	
}
