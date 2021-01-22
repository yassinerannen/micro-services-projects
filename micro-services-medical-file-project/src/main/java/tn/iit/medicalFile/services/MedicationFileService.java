package tn.iit.medicalFile.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.medicalFile.DTOs.MedicationFileDTO;
import tn.iit.medicalFile.mappers.MedicationFileMapper;
import tn.iit.medicalFile.repositories.MedicationFileRepository;

@Transactional
@Service
public class MedicationFileService {

	private final MedicationFileRepository medicationFileRepository;
	private final TreatmentService TreatmentService;

	@Autowired
	public MedicationFileService(MedicationFileRepository medicationFileRepository, TreatmentService TreatmentService) {
		this.medicationFileRepository = medicationFileRepository;
		this.TreatmentService = TreatmentService;
	}

	public MedicationFileDTO save(MedicationFileDTO MedicationFileDTO) {
		this.medicationFileRepository
				.saveAndFlush(MedicationFileMapper.MedicationFileDTOToMedicationFile(MedicationFileDTO));
		return MedicationFileDTO;
	}

	public void deleteById(Long id) {
		this.medicationFileRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Collection<MedicationFileDTO> findAll() {
		return MedicationFileMapper.MedicationFilesToMedicationFileDTOs(this.medicationFileRepository.findAll());
	}
}
