package tn.iit.medicalFile.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.medicalFile.DTOs.MedicationDTO;
import tn.iit.medicalFile.DTOs.TreatmentDTO;
import tn.iit.medicalFile.repositories.TreatmentRepository;
import tn.iit.medicalFile.mappers.TreatmentMapper;

@Transactional
@Service
public class TreatmentService {

	public Logger logger = LoggerFactory.getLogger(TreatmentService.class);
	private final TreatmentRepository treatmentRepository;
	private final StoreManagementClientService storeManagementClientService;

	@Autowired
	public TreatmentService(TreatmentRepository treatmentRepository,
			StoreManagementClientService storeManagementClientService) {
		this.treatmentRepository = treatmentRepository;
		this.storeManagementClientService = storeManagementClientService;
	}

	public TreatmentDTO save(TreatmentDTO treatmentDTO) {
		this.treatmentRepository.saveAndFlush(TreatmentMapper.TreatmentDTOToTreatment(treatmentDTO));
		return treatmentDTO;
	}

	public void deleteById(long id) {
		this.treatmentRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TreatmentDTO findTreatmentById(long id) {
		TreatmentDTO TreatmentDTO = TreatmentMapper.TreatmentToTreatmentDTO(this.treatmentRepository.getOne(id));
		MedicationDTO MedicationDTO = this.storeManagementClientService
				.getMedicationById(TreatmentDTO.getMedicationId());
		TreatmentDTO.setMedicationName(MedicationDTO.getName());
		TreatmentDTO.setMedicationPrice(MedicationDTO.getPrice());
		TreatmentDTO.setMedicationExpirationDate(MedicationDTO.getExpirationDate());
		return TreatmentDTO;
	}

}
