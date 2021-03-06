package com.ciu.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciu.app.PatientUpdater;
import com.ciu.app.dto.PatientDto;
import com.ciu.app.dto.mapper.DtoPatientMapper;

import com.ciu.app.entity.Patient;
import com.ciu.app.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	
	@Autowired
	private PatientService patientService;
	

    // Create a new patient

	@PostMapping
	public ResponseEntity<Patient> create(@RequestBody PatientDto patientDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(DtoPatientMapper.dtoToEntity(patientDto)));
	}
	
	// find patient by id
	
	
	@GetMapping("/{id}")
	
      public ResponseEntity<PatientDto> read(@PathVariable(value = "id") Long userId){
		
		Patient patient = patientService.findById(userId);
		
		
		if(patient == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(DtoPatientMapper.entityToDto(patient));
	}
	
	
	// update a patient

    @PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Patient patientDetails, @PathVariable(value = "id") Long patientId) {
		
    	// Primero obtengo el paciento por el id	
    	Patient patient = patientService.findById(patientId);
    	
    	// Actualizo el cliente
    	Patient patientUpdated = PatientUpdater.upDatePatient(patient, patientDetails);
    	
			if(patient == null) {
				
				return ResponseEntity.notFound().build();
			}
			

	             return ResponseEntity.status(HttpStatus.CREATED).
	        		body(patientService.save(patientUpdated));
	}
    
     
			
    // delete a patient

 	@DeleteMapping("/{id}")
 	public ResponseEntity<?> delete(@PathVariable(value = "id") Long patientId) {
 		
 		if (patientService.findById(patientId) == null) {
 			return ResponseEntity.notFound().build();
 		}

 		patientService.deleteById(patientId);
 		return ResponseEntity.ok().build();
 	}
	

    // read all patients

 	@GetMapping
 	public List<PatientDto> readAll() {

 		List<Patient> patients = StreamSupport.
 				stream(patientService.findAll().spliterator(), false).
 				collect(Collectors.toList());
 		
 		return DtoPatientMapper.entityListToDtoList(patients);
 	}
 	
}
