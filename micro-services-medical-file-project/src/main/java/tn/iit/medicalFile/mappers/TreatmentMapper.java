package tn.iit.medicalFile.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tn.iit.medicalFile.DTOs.MedicationFileDTO;
import tn.iit.medicalFile.DTOs.TreatmentDTO;
import tn.iit.medicalFile.entities.Treatment;

public class TreatmentMapper {

	public static TreatmentDTO TreatmentToTreatmentDTO(Treatment treatment) {
		TreatmentDTO TreatmentDTO = new TreatmentDTO();
		TreatmentDTO.setId(treatment.getId());
		TreatmentDTO.setMedicationId(treatment.getMedicationId());
		TreatmentDTO.setMedicationFileId(treatment.getMedicationFile().getId());
		return TreatmentDTO;
	}

	public static Treatment TreatmentDTOToTreatment(TreatmentDTO treatmentDTO) {
		Treatment Treatment = new Treatment();
		Treatment.setId(treatmentDTO.getId());
		Treatment.setMedicationId(treatmentDTO.getMedicationId());
		Treatment.setMedicationFile(MedicationFileMapper
				.MedicationFileDTOToMedicationFile(new MedicationFileDTO(treatmentDTO.getMedicationId())));
		return Treatment;
	}

	public static Collection<TreatmentDTO> TreatmentsToTreatmentDTOs(Collection<Treatment> Treatments) {
		List<TreatmentDTO> TreatmentDTOList = new ArrayList<>();
		Treatments.forEach(Treatment -> {
			TreatmentDTOList.add(TreatmentToTreatmentDTO(Treatment));
		});
		return TreatmentDTOList;
	}
}
