package tn.iit.medicalFile.controllers;

import org.springframework.web.bind.annotation.*;

import tn.iit.medicalFile.DTOs.MedicationFileDTO;
import tn.iit.medicalFile.entities.MedicationFile;
import tn.iit.medicalFile.mappers.PatientMapper;
import tn.iit.medicalFile.services.MedicationFileService;
import tn.iit.medicalFile.services.PatientService;

import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/MedicationFiles")
@RestController()
public class MedicationFileController {

	private final MedicationFileService MedicationFileService;
	private final PatientService patientService;

	public MedicationFileController(MedicationFileService MedicationFileService, PatientService patientService) {
		this.MedicationFileService = MedicationFileService;
		this.patientService = patientService;
	}

	@GetMapping
	public Collection<MedicationFileDTO> findAll() {
		return this.MedicationFileService.findAll();
	}

	@PostMapping
	public MedicationFileDTO add(@RequestBody MedicationFileDTO MedicationFileDTO) {
		MedicationFile medicationFile = new MedicationFile(
				PatientMapper.PatientDTOToPatient(this.patientService.findOne(MedicationFileDTO.getPatientId())));
		return this.MedicationFileService.save(MedicationFileDTO);
	}

	@PutMapping
	public MedicationFileDTO update(@RequestBody MedicationFileDTO MedicationFileDTO) {
		return this.MedicationFileService.save(MedicationFileDTO);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		this.MedicationFileService.deleteById(id);
	}
}
