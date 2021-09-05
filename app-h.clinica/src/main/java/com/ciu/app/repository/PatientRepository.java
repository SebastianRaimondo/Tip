package com.ciu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciu.app.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
