package tn.iit.medicalFile.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Treatment  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long medicationId;
	
	@ManyToOne
    @JoinColumn(name="medicationFile")
	private MedicationFile medicationFile;
	
	private int respectiveQuantity;
	
	public Treatment(long medicationId, MedicationFile medicationFile, int respectiveQuantity) {
		super();
		this.medicationId = medicationId;
		this.medicationFile = medicationFile;
		this.respectiveQuantity = respectiveQuantity;
	}
	
	public Treatment() {}

	public Treatment(long id, long medicationId, MedicationFile medicationFile, int respectiveQuantity) {
		super();
		this.id = id;
		this.medicationId = medicationId;
		this.medicationFile = medicationFile;
		this.respectiveQuantity = respectiveQuantity;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", medicationId=" + medicationId + ", medicationFile=" + medicationFile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((medicationFile == null) ? 0 : medicationFile.hashCode());
		result = prime * result + (int) (medicationId ^ (medicationId >>> 32));
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
		Treatment other = (Treatment) obj;
		if (id != other.id)
			return false;
		if (medicationFile == null) {
			if (other.medicationFile != null)
				return false;
		} else if (!medicationFile.equals(other.medicationFile))
			return false;
		if (medicationId != other.medicationId)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}

	public MedicationFile getMedicationFile() {
		return medicationFile;
	}

	public void setMedicationFile(MedicationFile medicationFile) {
		this.medicationFile = medicationFile;
	}

	public int getRespectiveQuantity() {
		return respectiveQuantity;
	}

	public void setRespectiveQuantity(int respectiveQuantity) {
		this.respectiveQuantity = respectiveQuantity;
	}
	
}
