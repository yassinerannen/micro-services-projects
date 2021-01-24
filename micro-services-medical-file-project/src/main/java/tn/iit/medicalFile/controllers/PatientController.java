package tn.iit.medicalFile.controllers;

import org.springframework.web.bind.annotation.*;

import tn.iit.medicalFile.DTOs.PatientDTO;
import tn.iit.medicalFile.services.PatientService;

import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/patients")
@RestController()
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping("{id}")
	public PatientDTO findOne(@PathVariable("id") long id) {
		return this.patientService.findOne(id);
	}

	@GetMapping
	public Collection<PatientDTO> findAll() {
		return this.patientService.findAll();
	}

	@PostMapping
	public PatientDTO add(@RequestBody PatientDTO PatientDTO) {
		return this.patientService.save(PatientDTO);
	}

	@PutMapping("{id}")
	public PatientDTO update(@RequestBody PatientDTO PatientDTO) {
		return this.patientService.save(PatientDTO);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		this.patientService.deleteById(id);
	}
}
