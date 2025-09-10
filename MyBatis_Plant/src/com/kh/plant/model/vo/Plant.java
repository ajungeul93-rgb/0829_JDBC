package com.kh.plant.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Plant {

	private int plantId;
	private String plantName;
	private String plantType;
	private Date plantedDate;
	private String wateringCycle;
	private String plantStatus;

	public Plant() {
		super();
	}
	
	

	public Plant(String plantName, String plantType, String wateringCycle, String plantStatus) {
		super();
		this.plantName = plantName;
		this.plantType = plantType;
		this.wateringCycle = wateringCycle;
		this.plantStatus = plantStatus;
	}



	public Plant(int plantId, String plantName, String plantType, Date plantedDate, String wateringCycle,
			String plantStatus) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantType = plantType;
		this.plantedDate = plantedDate;
		this.wateringCycle = wateringCycle;
		this.plantStatus = plantStatus;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public Date getPlantedDate() {
		return plantedDate;
	}

	public void setPlantedDate(Date plantedDate) {
		this.plantedDate = plantedDate;
	}

	public String getWateringCycle() {
		return wateringCycle;
	}

	public void setWateringCycle(String wateringCycle) {
		this.wateringCycle = wateringCycle;
	}

	public String getPlantStatus() {
		return plantStatus;
	}

	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}

	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantName=" + plantName + ", plantType=" + plantType + ", plantedDate="
				+ plantedDate + ", wateringCycle=" + wateringCycle + ", plantStatus=" + plantStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(plantId, plantName, plantStatus, plantType, plantedDate, wateringCycle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plant other = (Plant) obj;
		return plantId == other.plantId && Objects.equals(plantName, other.plantName)
				&& Objects.equals(plantStatus, other.plantStatus) && Objects.equals(plantType, other.plantType)
				&& Objects.equals(plantedDate, other.plantedDate) && Objects.equals(wateringCycle, other.wateringCycle);
	}

}
