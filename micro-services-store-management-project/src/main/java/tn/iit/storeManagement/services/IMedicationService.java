package tn.iit.storeManagement.services;

import java.util.Collection;

import tn.iit.storeManagement.DTOs.MedicationDTO;

public interface IMedicationService {
	Collection<MedicationDTO> getAllMedications();

	MedicationDTO save(MedicationDTO medicationDTO);

	MedicationDTO update(MedicationDTO medicationDTO);

	MedicationDTO findById(long id);

	void delete(long id);
}
