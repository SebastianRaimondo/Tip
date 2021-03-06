package com.ciu.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ciu.app.entity.Patient;

public interface PatientService {
	
	public Iterable<Patient> findAll();
	
	public Page<Patient> findAll(Pageable pageable);
	
	public Patient findById(Long id);
	
	public Patient save(Patient patient);
	
	public void deleteById(Long id);

}
