package com.kh.plant.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.vo.Plant;

public class PlantService {
	
	private final PlantDao plantDao = new PlantDao();

	public List<Plant> findAll() {
		
		SqlSession session = Template.getSqlSession();
		
		List<Plant> plant = plantDao.findAll(session);
		
		session.close();
		
		return plant;
	}

	public int insertPlant(Plant plant) {

		SqlSession session = Template.getSqlSession();
		
		int result = plantDao.insertPlant(session, plant);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

	public List<Plant> findByPlantType(String plantType) {

		SqlSession session = Template.getSqlSession();
		
		List<Plant> plant = plantDao.findByPlantTpye(session, plantType);
		
		session.close();
		
		return plant;
	}

}
