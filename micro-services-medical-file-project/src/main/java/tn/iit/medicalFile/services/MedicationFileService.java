package tn.iit.medicalFile.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.medicalFile.mappers.*;
import tn.iit.medicalFile.repositories.*;
import tn.iit.medicalFile.services.*;
import tn.iit.medicalFile.DTOs.*;
import tn.iit.medicalFile.entities.*;

@Transactional
@Service
public class MedicationFileService {

	private MedicationFileRepository medicationFileRepository;
	private TreatmentService treatmentService;

	@Autowired
	public MedicationFileService(MedicationFileRepository medicationFileRepository, TreatmentService treatmentService) {
		this.medicationFileRepository = medicationFileRepository;
		this.treatmentService = treatmentService;
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
		Collection<MedicationFile> resultMedicationFiles = this.medicationFileRepository.findAll();
		Collection<MedicationFileDTO> resultMedicationFileDTOs = MedicationFileMapper
				.MedicationFilesToMedicationFileDTOs(resultMedicationFiles);

		resultMedicationFileDTOs.forEach(MedicationFileDTO -> {
			long id = MedicationFileDTO.getId();
			MedicationFileDTO.setTreatments(this.treatmentService.findAllByMedicationFileId(id));
		});

		return resultMedicationFileDTOs;
	}

	@Transactional(readOnly = true)
	public MedicationFileDTO findMedicationFileById(long id) {
		MedicationFileDTO medicationFileDTO = MedicationFileMapper
				.MedicationFileToMedicationFileDTO(this.medicationFileRepository.getOne(id));
		medicationFileDTO.setTreatments(this.treatmentService.findAllByMedicationFileId(id));
		return medicationFileDTO;
	}

}
