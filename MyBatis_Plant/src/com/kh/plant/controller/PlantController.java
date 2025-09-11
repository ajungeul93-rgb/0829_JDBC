package com.kh.plant.controller;

import java.util.List;

import com.kh.plant.model.dto.PlantDTO;
import com.kh.plant.model.service.PlantService;
import com.kh.plant.model.vo.Plant;

public class PlantController {

	public List<Plant> findAll() {

		List<Plant> plant = new PlantService().findAll();
		
		return plant;
	}

	public int insertPlant(String plantName, String plantType, String wateringCycle, String plantStatus) {

		Plant plant = new Plant(plantName, plantType, wateringCycle, plantStatus);
		
		int result = new PlantService().insertPlant(plant);
		
		return result;
	}

	public List<Plant> findByPlantType(String plantType) {
		
		List<Plant> plant = new PlantService().findByPlantType(plantType);
		
		return plant;
	}

	public int updateStatus(int plantId, String plantName, String plantStatus) {
		
		PlantDTO pd = new PlantDTO(plantId, plantName, plantStatus);

		int result = new PlantService().updateStatus(pd);
		
		return result;
	}

	public int deletePlant(int plantId, String plantName) {

		PlantDTO pd = new PlantDTO(plantId, plantName);
		
		int result = new PlantService().deletePlant(pd);
		
		return result;
	}

	public Plant findByPlant(int plantId) {

		Plant plant = new PlantService().findByPlant(plantId);
		
		return plant;
	}

	public List<Plant> findByKeyword(String keyword) {

		List<Plant> plant = new PlantService().findByKeyword(keyword);
		
		return plant;
	}

}
