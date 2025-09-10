package com.kh.plant.controller;

import java.util.List;

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

}
