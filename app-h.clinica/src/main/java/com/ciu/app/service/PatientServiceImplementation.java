package com.ciu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciu.app.entity.Patient;
import com.ciu.app.repository.PatientRepository;

@Service
public class PatientServiceImplementation implements PatientService{

	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Patient> findAll() {
	   return this.patientRepository.findAll();
	}
	

	@Override
	@Transactional(readOnly = true)
	public Page<Patient> findAll(Pageable pageable) {
		return this.patientRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Patient findById(Long id) {
		return this.patientRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Patient save(Patient patient) {
		return this.patientRepository.save(patient);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.patientRepository.deleteById(id);
	}

}
