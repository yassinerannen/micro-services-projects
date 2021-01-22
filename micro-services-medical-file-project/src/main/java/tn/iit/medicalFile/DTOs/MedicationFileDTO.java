package tn.iit.medicalFile.DTOs;

import java.util.Collection;

public class MedicationFileDTO {
	
	private long id;

    private long patientId;
    
    private String patientFirstName;
    
    private String patientLastName;
    
    private Collection<TreatmentDTO> Treatments;
    
    public MedicationFileDTO(long id) {
		super();
		this.id = id;
	}
    
    public MedicationFileDTO(long patientId, String patientFirstName, String patientLastName, Collection<TreatmentDTO> treatments) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		Treatments = treatments;
	}
    
    public MedicationFileDTO() {}

	public MedicationFileDTO(long id, long patientId, String patientFirstName, String patientLastName, Collection<TreatmentDTO> treatments) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		Treatments = treatments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Treatments == null) ? 0 : Treatments.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((patientFirstName == null) ? 0 : patientFirstName.hashCode());
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((patientLastName == null) ? 0 : patientLastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicationFileDTO other = (MedicationFileDTO) obj;
		if (Treatments == null) {
			if (other.Treatments != null)
				return false;
		} else if (!Treatments.equals(other.Treatments))
			return false;
		if (id != other.id)
			return false;
		if (patientFirstName == null) {
			if (other.patientFirstName != null)
				return false;
		} else if (!patientFirstName.equals(other.patientFirstName))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientLastName == null) {
			if (other.patientLastName != null)
				return false;
		} else if (!patientLastName.equals(other.patientLastName))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public Collection<TreatmentDTO> getTreatments() {
		return Treatments;
	}

	public void setTreatments(Collection<TreatmentDTO> treatments) {
		Treatments = treatments;
	}

	

}
