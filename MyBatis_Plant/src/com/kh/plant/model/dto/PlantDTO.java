package com.kh.plant.model.dto;

public class PlantDTO {

	private int plantId;
	private String plantName;
	private String plantStatus;


	
	
	public PlantDTO() {
		super();
	}



	public PlantDTO(int plantId, String plantName, String plantStatus) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantStatus = plantStatus;
    }
	
	

	public PlantDTO(int plantId, String plantName) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
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



	public String getPlantStatus() {
		return plantStatus;
	}



	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}


	
}
