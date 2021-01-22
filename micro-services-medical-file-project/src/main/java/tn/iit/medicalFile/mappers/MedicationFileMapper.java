package tn.iit.medicalFile.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tn.iit.medicalFile.DTOs.MedicationFileDTO;
import tn.iit.medicalFile.DTOs.PatientDTO;
import tn.iit.medicalFile.entities.MedicationFile;

public class MedicationFileMapper {

	public static MedicationFileDTO MedicationFileToMedicationFileDTO(MedicationFile medicationFile) {
		MedicationFileDTO MedicationFileDTO = new MedicationFileDTO();
		MedicationFileDTO.setId(medicationFile.getId());
		MedicationFileDTO.setPatientId(medicationFile.getPatient().getId());
		MedicationFileDTO.setPatientFirstName(medicationFile.getPatient().getFirstName());
		MedicationFileDTO.setPatientLastName(medicationFile.getPatient().getLastName());
		return MedicationFileDTO;
	}

	public static MedicationFile MedicationFileDTOToMedicationFile(MedicationFileDTO medicationFileDTO) {
		MedicationFile MedicationFile = new MedicationFile();
		MedicationFile.setId(medicationFileDTO.getId());
		MedicationFile.setPatient(PatientMapper.PatientDTOToPatient(new PatientDTO(medicationFileDTO.getPatientId(),
				medicationFileDTO.getPatientFirstName(), medicationFileDTO.getPatientLastName())));
		return MedicationFile;
	}

	public static Collection<MedicationFileDTO> MedicationFilesToMedicationFileDTOs(
			Collection<MedicationFile> medicationFiles) {
		List<MedicationFileDTO> MedicationFileDTOList = new ArrayList<>();
		medicationFiles.forEach(medicationFile -> {
			MedicationFileDTOList.add(MedicationFileToMedicationFileDTO(medicationFile));
		});
		return MedicationFileDTOList;
	}

}
