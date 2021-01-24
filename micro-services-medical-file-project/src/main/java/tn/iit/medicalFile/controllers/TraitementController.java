package tn.iit.medicalFile.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.*;

import tn.iit.medicalFile.DTOs.*;
import tn.iit.medicalFile.services.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/treatments")
@RestController()
public class TraitementController {

	private TreatmentService treatmentService;

	public TraitementController(TreatmentService treatmentService) {
		this.treatmentService = treatmentService;
	}
	
	@GetMapping
	public Collection<TreatmentDTO> findAll() {
		return this.treatmentService.findAll();
	}
	
	@GetMapping("{id}")
	public TreatmentDTO findOne(@PathVariable("id") long id) {
		return this.treatmentService.findTreatmentById(id);
	}
	
	@GetMapping("/medFile/{id}")
	public Collection<TreatmentDTO> findAllByMedicationFileId(@PathVariable("id") long id) {
		return this.treatmentService.findAllByMedicationFileId(id);
	}

	@PostMapping
	public TreatmentDTO add(@RequestBody TreatmentDTO TreatmentDTO) {
		return this.treatmentService.save(TreatmentDTO);
	}

	@PutMapping("{id}")
	public TreatmentDTO update(@RequestBody TreatmentDTO TreatmentDTO) {
		return this.treatmentService.save(TreatmentDTO);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		this.treatmentService.deleteById(id);
	}
}
