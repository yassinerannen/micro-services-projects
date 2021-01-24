package tn.iit.medicalFile.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.medicalFile.DTOs.PatientDTO;
import tn.iit.medicalFile.mappers.PatientMapper;
import tn.iit.medicalFile.repositories.PatientRepository;

@Transactional
@Service
public class PatientService {

	private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDTO save(PatientDTO PatientDTO) {
        this.patientRepository.saveAndFlush(PatientMapper.PatientDTOToPatient(PatientDTO));
        return PatientDTO;
    }

    public void deleteById(Long id) {
        this.patientRepository.deleteById(id);
    }
    
    @Transactional(readOnly = true)
    public PatientDTO findOne(Long id) {
        return PatientMapper.patientToPatientDTO(this.patientRepository.getOne(id));
    }
    
    @Transactional(readOnly = true)
    public Collection<PatientDTO> findAll() {
        return PatientMapper.patientsToPatientDTOs(this.patientRepository.findAll ());
    }
}
