package tn.iit.medicalFile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.medicalFile.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
