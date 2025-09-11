package com.kh.plant.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.plant.model.dto.PlantDTO;
import com.kh.plant.model.vo.Plant;

public class PlantDao {

	public List<Plant> findAll(SqlSession session) {
		
		return session.selectList("plantMapper.findAll");
		
	}

	public int insertPlant(SqlSession session, Plant plant) {

		return session.insert("plantMapper.insertPlant", plant);
		
	}

	public List<Plant> findByPlantTpye(SqlSession session, String plantType) {

		return session.selectList("plantMapper.findByPlantType", plantType);
		
	}

	public int checkPlant(SqlSession session, PlantDTO pd) {

		return session.selectOne("plantMapper.checkPlant", pd);
		
	}
	
	public int updateStatus(SqlSession session, PlantDTO pd) {

		return session.update("plantMapper.updateStatus", pd);
	}

	public int deletePlant(SqlSession session, PlantDTO pd) {

		return session.delete("plantMapper.deletePlant", pd);
	}

	public Plant findByPlant(SqlSession session, int plantId) {

		return session.selectOne("plantMapper.findByPlant", plantId);
	}

	public List<Plant> findByKeyword(SqlSession session, String keyword) {

		return session.selectList("plantMapper.findByKeyword", keyword);
	}


}
