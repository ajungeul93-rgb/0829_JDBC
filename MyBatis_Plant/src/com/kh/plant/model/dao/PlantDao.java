package com.kh.plant.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.plant.model.vo.Plant;

public class PlantDao {

	public List<Plant> findAll(SqlSession session) {
		
		return session.selectList("plantMapper.findAll");
		
	}

	public int insertPlant(SqlSession session, Plant plant) {

		return session.insert("plantMapper.insertPlant", plant);
		
	}

}
