package tn.iit.storeManagement.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.storeManagement.DTOs.MedicationDTO;
import tn.iit.storeManagement.entities.Medication;
import tn.iit.storeManagement.exceptions.ResourceNotFoundException;
import tn.iit.storeManagement.mappers.MedicationMapper;
import tn.iit.storeManagement.repositories.MedicationRepository;

@Service
public class MedicationService implements IMedicationService {

	@Autowired
	MedicationRepository medicationRepository;

	@Override
	public Collection<MedicationDTO> getAllMedications() {
		return MedicationMapper.medicationsToMedicationDTOs(medicationRepository.findAll());
	}

	@Override
	public MedicationDTO save(MedicationDTO medicationDTO) {
		medicationRepository.saveAndFlush(MedicationMapper.MedicationDTOToMedication(medicationDTO));
		return medicationDTO;
	}

	@Override
	public MedicationDTO update(MedicationDTO medicationDTO) {
		Medication medication = MedicationMapper.MedicationDTOToMedication(medicationDTO);
		medication = medicationRepository.save(medication);
		MedicationDTO resultMedicationDTO = MedicationMapper.medicationToMedicationDTO(medication);
		return resultMedicationDTO;
	}

	@Override
	public MedicationDTO findById(long id) {
		Medication medication = medicationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicament with id " + id + " not found"));
		return MedicationMapper.medicationToMedicationDTO(medication);
	}

	@Override
	public void delete(long id) {
		if (!medicationRepository.existsById(id))
			throw new ResourceNotFoundException("Missing medication with id : " + id);
		medicationRepository.deleteById(id);
	}

}
