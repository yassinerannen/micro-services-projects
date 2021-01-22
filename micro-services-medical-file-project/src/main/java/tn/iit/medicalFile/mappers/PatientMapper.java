package tn.iit.medicalFile.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tn.iit.medicalFile.DTOs.PatientDTO;
import tn.iit.medicalFile.entities.Patient;

public class PatientMapper {

	public static PatientDTO patientToPatientDTO(Patient patient) {
		PatientDTO PatientDTO = new PatientDTO();
		PatientDTO.setId(patient.getId());
		PatientDTO.setFirstName(patient.getFirstName());
		PatientDTO.setLastName(patient.getLastName());
		return PatientDTO;
	}

	public static Patient PatientDTOToPatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		patient.setId(patientDTO.getId());
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		return patient;
	}

	public static Collection<PatientDTO> patientsToPatientDTOs(Collection<Patient> patients) {
		List<PatientDTO> PatientDTOList = new ArrayList<>();
		patients.forEach(patient -> {
			PatientDTOList.add(patientToPatientDTO(patient));
		});
		return PatientDTOList;
	}
}
