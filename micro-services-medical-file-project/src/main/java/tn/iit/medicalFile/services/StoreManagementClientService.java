package tn.iit.medicalFile.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import tn.iit.medicalFile.DTOs.MedicationDTO;

public class StoreManagementClientService {

	private Logger logger = LoggerFactory.getLogger(StoreManagementClientService.class);

	private final RestTemplate restTemplate;

	public StoreManagementClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<MedicationDTO> getAllMedications() {
		logger.debug("Getting all medicaments");
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:9999/api/medications/")
				.build().encode();
		return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()),
				new ParameterizedTypeReference<List<MedicationDTO>>() {
				}).getBody();
	}

	public MedicationDTO getMedicationById(Long id) {
		logger.debug("Getting Medicament with id {}", id);
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:9999/api/medications/")
				.path("/{id}").build().expand(id).encode();
		return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()),
				MedicationDTO.class).getBody();
	}

}
