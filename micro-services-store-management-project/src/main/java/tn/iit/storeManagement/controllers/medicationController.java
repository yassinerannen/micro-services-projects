package tn.iit.storeManagement.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.storeManagement.DTOs.MedicationDTO;
import tn.iit.storeManagement.services.MedicationService;

@CrossOrigin("*")
@RequestMapping(value = "/api/medications")
@RestController()
public class medicationController {

	@Autowired
	private MedicationService medicationService;

	@GetMapping()
	public Collection<MedicationDTO> findAll() {
		return medicationService.getAllMedications();
	}

	@GetMapping("/{id}")
	public MedicationDTO findById(@PathVariable("id") long id) {
		return medicationService.findById(id);
	}

	@PostMapping
	public MedicationDTO add(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.save(medicationDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		medicationService.delete(id);
	}

	@PutMapping()
	public MedicationDTO update(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.save(medicationDTO);
	}

}
