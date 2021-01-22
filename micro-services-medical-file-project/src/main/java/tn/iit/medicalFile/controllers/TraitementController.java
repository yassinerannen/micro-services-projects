package tn.iit.medicalFile.controllers;

import org.springframework.web.bind.annotation.*;

import tn.iit.medicalFile.DTOs.TreatmentDTO;
import tn.iit.medicalFile.services.TreatmentService;

@CrossOrigin("*")
@RequestMapping(value = "/api/traitements")
@RestController()
public class TraitementController {

	private final TreatmentService treatmentService;

	public TraitementController(TreatmentService treatmentService) {
		this.treatmentService = treatmentService;
	}

	@PostMapping
	public TreatmentDTO add(@RequestBody TreatmentDTO TreatmentDTO) {
		return this.treatmentService.save(TreatmentDTO);
	}

	@PutMapping
	public TreatmentDTO update(@RequestBody TreatmentDTO TreatmentDTO) {
		return this.treatmentService.save(TreatmentDTO);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		this.treatmentService.deleteById(id);
	}
}
