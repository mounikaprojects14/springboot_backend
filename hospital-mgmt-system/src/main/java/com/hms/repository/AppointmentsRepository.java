package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.AppointmentsModel;

@Repository
public interface AppointmentsRepository extends JpaRepository<AppointmentsModel, Long> {
 
	
}
