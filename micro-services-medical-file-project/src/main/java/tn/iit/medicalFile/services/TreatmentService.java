package tn.iit.medicalFile.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.medicalFile.DTOs.*;
import tn.iit.medicalFile.entities.*;
import tn.iit.medicalFile.repositories.*;
import tn.iit.medicalFile.mappers.*;

@Transactional
@Service
public class TreatmentService {

	private TreatmentRepository treatmentRepository;
	private StoreManagementClientService storeManagementClientService;

	@Autowired
	public TreatmentService(TreatmentRepository treatmentRepository,
			StoreManagementClientService storeManagementClientService) {
		this.treatmentRepository = treatmentRepository;
		this.storeManagementClientService = storeManagementClientService;
	}

	@Transactional(readOnly = true)
	public Collection<TreatmentDTO> findAll() {
		Collection <Treatment> treatments = this.treatmentRepository.findAll();
		Collection<TreatmentDTO> treatmentDTOs = TreatmentMapper.TreatmentsToTreatmentDTOs(treatments);
		
		treatmentDTOs.forEach(TreatmentDTO -> {
			MedicationDTO medicationDTO = this.storeManagementClientService
					.getMedicationById(TreatmentDTO.getMedicationId());
			TreatmentDTO.setMedicationExpirationDate(medicationDTO.getExpirationDate());
			TreatmentDTO.setMedicationName(medicationDTO.getName());
			TreatmentDTO.setMedicationPrice(medicationDTO.getPrice());

		});
		
		return treatmentDTOs;
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

	@Transactional(readOnly = true)
	public Collection<TreatmentDTO> findAllByMedicationFileId(long medicationFileId) {

		Collection<TreatmentDTO> TreatmentDTOs = TreatmentMapper
				.TreatmentsToTreatmentDTOs(this.treatmentRepository.findByMedicationFileId(medicationFileId));

		TreatmentDTOs.forEach(TreatmentDTO -> {
			MedicationDTO medicationDTO = this.storeManagementClientService
					.getMedicationById(TreatmentDTO.getMedicationId());
			TreatmentDTO.setMedicationExpirationDate(medicationDTO.getExpirationDate());
			TreatmentDTO.setMedicationName(medicationDTO.getName());
			TreatmentDTO.setMedicationPrice(medicationDTO.getPrice());

		});
		
		return TreatmentDTOs;
	}

}
