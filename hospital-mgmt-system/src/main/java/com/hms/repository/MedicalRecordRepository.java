package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.model.MedicalRecordModel;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecordModel, Long> {

}
