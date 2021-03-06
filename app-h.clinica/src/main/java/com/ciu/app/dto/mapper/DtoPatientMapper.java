package com.ciu.app.dto.mapper;



import java.util.List;
import java.util.stream.Collectors;




import com.ciu.app.dto.PatientDto;
import com.ciu.app.entity.Patient;


public class DtoPatientMapper {
	

	
	public static PatientDto entityToDto(Patient patient) {
		
		PatientDto result = new PatientDto(
				patient.getName(),
				patient.getSurname(),
				patient.getPhoneNumber(),
				patient.getAddress(),
				patient.getDni()); 
		
		
		return result;
		
	}
	
public static Patient dtoToEntity(PatientDto patientDto) {
		
		Patient result = new Patient();
		result.setSurname(patientDto.getSurname());
		result.setPhoneNumber(patientDto.getPhoneNumber());
		result.setAddress(patientDto.getAddress());
		result.setDni(patientDto.getDni()); 
		result.setName(patientDto.getName()); 
		
		
		return result;
		
	}


public static List<PatientDto> entityListToDtoList(List<Patient> patienList){
	
	//List<Patient> patients = StreamSupport.
			//	stream(pService.findAll().spliterator(), false).
			//	collect(Collectors.toList());
	
	    
	return  patienList.stream().map(p -> entityToDto(p)).collect(Collectors.toList());
	
	
}

}
