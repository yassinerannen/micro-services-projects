package tn.iit.storeManagement.mappers;

import java.util.ArrayList;
import java.util.Collection;

import tn.iit.storeManagement.DTOs.MedicationDTO;
import tn.iit.storeManagement.entities.Medication;

public class MedicationMapper {

	public static MedicationDTO medicationToMedicationDTO(Medication medication) {
		MedicationDTO medicationDTO = new MedicationDTO();
		medicationDTO.setId(medication.getId());
		medicationDTO.setName(medication.getName());
		medicationDTO.setPrice(medication.getPrice());
		medicationDTO.setExpirationDate(medication.getExpirationDate());
		return medicationDTO;
	}

	public static Medication MedicationDTOToMedication(MedicationDTO medicationDTO) {
		Medication medication = new Medication();
		medication.setId(medicationDTO.getId());
		medication.setName(medicationDTO.getName());
		medication.setPrice(medicationDTO.getPrice());
		medication.setExpirationDate(medicationDTO.getExpirationDate());
		return medication;
	}

	public static Collection<MedicationDTO> medicationsToMedicationDTOs(Collection<Medication> medications) {
		Collection<MedicationDTO> MedicationDTOs = new ArrayList<>();
		medications.forEach(medication -> {
			MedicationDTOs.add(medicationToMedicationDTO(medication));
		});
		return MedicationDTOs;
	}

}
