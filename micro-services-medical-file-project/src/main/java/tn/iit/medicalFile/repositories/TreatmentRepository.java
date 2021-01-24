package tn.iit.medicalFile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.medicalFile.entities.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
	
	public List<Treatment> findByMedicationFileId(long medicationFileId);
	
}
