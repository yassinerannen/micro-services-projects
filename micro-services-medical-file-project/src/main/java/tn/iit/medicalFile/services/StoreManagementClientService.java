package tn.iit.medicalFile.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import tn.iit.medicalFile.DTOs.*;

@Service
public class StoreManagementClientService {

	private Logger logger = LoggerFactory.getLogger(StoreManagementClientService.class);

	private RestTemplate restTemplate;

	@Autowired
	public StoreManagementClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public MedicationDTO getMedicationById(Long id) {
		logger.debug("Getting medication from store management application with id {}", id);
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://store-mangement-app:9999/api/medications/")
				.path("/{id}").build().expand(id).encode();
		return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()),
				MedicationDTO.class).getBody();
	}

}
