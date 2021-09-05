package com.ciu.app;

import com.ciu.app.entity.Patient;

public class PatientUpdater {
	
	
	public static Patient upDatePatient(Patient patient, Patient pDetails) {
		
		patient.setAddress(pDetails.getAddress());
		patient.setDni(pDetails.getDni());
		patient.setName(pDetails.getName());
		patient.setSurname(pDetails.getSurname());
		patient.setPhoneNumber(pDetails.getPhoneNumber());
		
	
		return patient;
	}

}
