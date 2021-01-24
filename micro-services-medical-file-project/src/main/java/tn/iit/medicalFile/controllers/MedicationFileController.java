package tn.iit.medicalFile.controllers;

import org.springframework.web.bind.annotation.*;

import tn.iit.medicalFile.DTOs.*;
import tn.iit.medicalFile.entities.*;
import tn.iit.medicalFile.mappers.*;
import tn.iit.medicalFile.services.*;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/MedicationFiles")
@RestController()
public class MedicationFileController {

	private MedicationFileService MedicationFileService;
	private PatientService patientService;

	public MedicationFileController(MedicationFileService MedicationFileService, PatientService patientService) {
		this.MedicationFileService = MedicationFileService;
		this.patientService = patientService;
	}

	@GetMapping
	public Collection<MedicationFileDTO> findAll() {
		return this.MedicationFileService.findAll();
	}
	
	@GetMapping("{id}")
	public MedicationFileDTO findOne(@PathVariable("id") long id) {
		return this.MedicationFileService.findMedicationFileById(id);
	}

	@PostMapping
	public MedicationFileDTO add(@RequestBody MedicationFileDTO MedicationFileDTO) {
		MedicationFile medicationFile = new MedicationFile(
				PatientMapper.PatientDTOToPatient(this.patientService.findOne(MedicationFileDTO.getPatientId())));
		MedicationFileDTO resultMedicationFileDTO = MedicationFileMapper.MedicationFileToMedicationFileDTO(medicationFile);
		return this.MedicationFileService.save(resultMedicationFileDTO);
	}

	@PutMapping("{id}")
	public MedicationFileDTO update(@RequestBody MedicationFileDTO MedicationFileDTO) {
		return this.MedicationFileService.save(MedicationFileDTO);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		this.MedicationFileService.deleteById(id);
	}
}
