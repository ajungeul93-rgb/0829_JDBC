package com.kh.plant.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.PlantDTO;
import com.kh.plant.model.vo.Plant;

public class PlantService {

	private final PlantDao plantDao = new PlantDao();

	public List<Plant> findAll() {

		SqlSession session = Template.getSqlSession();

		List<Plant> plant = null;

		try {

			plant = plantDao.findAll(session);

		} finally {

			session.close();

		}

		return plant;
	}

	public int insertPlant(Plant plant) {

		SqlSession session = Template.getSqlSession();

		int result = 0;

		try {

			result = plantDao.insertPlant(session, plant);

			if (result > 0) {

				session.commit();

			}

		} catch (Exception e) {

			session.rollback();

			throw new RuntimeException("식물 정보 등록에 실패했습니다.", e);

		} finally {

			session.close();

		}

		return result;
	}

	public List<Plant> findByPlantType(String plantType) {

		SqlSession session = Template.getSqlSession();

		List<Plant> plant = null;
		try {

			plant = plantDao.findByPlantTpye(session, plantType);

		} finally {

			session.close();

		}

		return plant;
	}

	public int updateStatus(PlantDTO pd) {

		SqlSession session = Template.getSqlSession();

		int result = 0;

		try {

			int checkResult = plantDao.checkPlant(session, pd);

			if (checkResult > 0) {

				result = plantDao.updateStatus(session, pd);

				if (result > 0) {

					session.commit();

				}
			}

		} catch (Exception e) {

			session.rollback();

			throw new RuntimeException("식물이 존재하지 않아 상태 변경에 실패하였습니다. ", e);

		} finally {

			session.close();

		}

		return result;
	}

	public int deletePlant(PlantDTO pd) {

		SqlSession session = Template.getSqlSession();

		int result = 0;

		try {

			int checkResult = plantDao.checkPlant(session, pd);

			if (checkResult > 0) {

				result = plantDao.deletePlant(session, pd);

				if (result > 0) {

					session.commit();

				}
			}

		} catch (Exception e) {

			session.rollback();

			throw new RuntimeException("해당 식물이 존재하지 않아 삭제에 실패하였습니다.", e);

		} finally {

			session.close();

		}

		return result;
	}

	public Plant findByPlant(int plantId) {

		SqlSession session = Template.getSqlSession();

		Plant plant = null;

		try {

			plant = plantDao.findByPlant(session, plantId);
		
		} finally {

			session.close();
		}
		
		return plant;
	}

	public List<Plant> findByKeyword(String keyword) {

		SqlSession session = Template.getSqlSession();

		List<Plant> plant = null;

		try {
			
			plant = plantDao.findByKeyword(session, keyword);
		
		} finally {
			
			session.close();
			
		}
		
		return plant;
	
	}

}
