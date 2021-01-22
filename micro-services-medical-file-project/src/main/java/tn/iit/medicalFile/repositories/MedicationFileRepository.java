package tn.iit.medicalFile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.medicalFile.entities.MedicationFile;

@Repository
public interface MedicationFileRepository extends JpaRepository<MedicationFile, Long> {

}
