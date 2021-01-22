package tn.iit.medicalFile.DTOs;

import java.util.Date;

public class TreatmentDTO {
	
	private long id;
	
	private long medicationId;
	
	private String medicationName;
		
	private float medicationPrice;
		
	private Date medicationExpirationDate;
	
	private long medicationFileId;
	
	private int respectiveQuantity;
	
	public TreatmentDTO(long medicationId, String medicationName, float medicationPrice,
			Date medicationExpirationDate, long medicationFileId, int respectiveQuantity) {
		super();
		this.medicationId = medicationId;
		this.medicationName = medicationName;
		this.medicationPrice = medicationPrice;
		this.medicationExpirationDate = medicationExpirationDate;
		this.medicationFileId = medicationFileId;
		this.respectiveQuantity = respectiveQuantity;
	}
	
	public TreatmentDTO() {}

	public TreatmentDTO(long id, long medicationId, String medicationName, float medicationPrice,
			Date medicationExpirationDate, long medicationFileId, int respectiveQuantity) {
		super();
		this.id = id;
		this.medicationId = medicationId;
		this.medicationName = medicationName;
		this.medicationPrice = medicationPrice;
		this.medicationExpirationDate = medicationExpirationDate;
		this.medicationFileId = medicationFileId;
		this.respectiveQuantity = respectiveQuantity;
	}

	@Override
	public String toString() {
		return "TreatmentDTO [id=" + id + ", medicationId=" + medicationId + ", medicationName=" + medicationName
				+ ", medicationPrice=" + medicationPrice + ", medicationExpirationDate=" + medicationExpirationDate
				+ ", medicationFile=" + medicationFileId + ", respectiveQuantity=" + respectiveQuantity + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((medicationExpirationDate == null) ? 0 : medicationExpirationDate.hashCode());
		result = prime * result + (int) (medicationFileId ^ (medicationFileId >>> 32));
		result = prime * result + (int) (medicationId ^ (medicationId >>> 32));
		result = prime * result + ((medicationName == null) ? 0 : medicationName.hashCode());
		result = prime * result + Float.floatToIntBits(medicationPrice);
		result = prime * result + respectiveQuantity;
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
		TreatmentDTO other = (TreatmentDTO) obj;
		if (id != other.id)
			return false;
		if (medicationExpirationDate == null) {
			if (other.medicationExpirationDate != null)
				return false;
		} else if (!medicationExpirationDate.equals(other.medicationExpirationDate))
			return false;
		if (medicationFileId != other.medicationFileId)
			return false;
		if (medicationId != other.medicationId)
			return false;
		if (medicationName == null) {
			if (other.medicationName != null)
				return false;
		} else if (!medicationName.equals(other.medicationName))
			return false;
		if (Float.floatToIntBits(medicationPrice) != Float.floatToIntBits(other.medicationPrice))
			return false;
		if (respectiveQuantity != other.respectiveQuantity)
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

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public float getMedicationPrice() {
		return medicationPrice;
	}

	public void setMedicationPrice(float medicationPrice) {
		this.medicationPrice = medicationPrice;
	}

	public Date getMedicationExpirationDate() {
		return medicationExpirationDate;
	}

	public void setMedicationExpirationDate(Date medicationExpirationDate) {
		this.medicationExpirationDate = medicationExpirationDate;
	}

	public long getMedicationFileId() {
		return medicationFileId;
	}

	public void setMedicationFileId(long medicationFileId) {
		this.medicationFileId = medicationFileId;
	}

	public int getRespectiveQuantity() {
		return respectiveQuantity;
	}

	public void setRespectiveQuantity(int respectiveQuantity) {
		this.respectiveQuantity = respectiveQuantity;
	}
	
}
