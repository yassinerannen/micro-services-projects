package tn.iit.storeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.storeManagement.entities.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
