package com.kh.computer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.vo.Computer;

public class ComputerService {
	
	private final ComputerDao computerDao = new ComputerDao();


	public int addPcPart(Computer computer) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = computerDao.addPcPart(session, computer);
		
		return result;
	}

	public List<Computer> viewAll() {
		
		SqlSession session = Template.getSqlSession();
		
		List<Computer> computer = computerDao.viewAll(session);
		
		session.close();
		
		return computer;
	}

	public List<Computer> findCategory(String category) {
		
		SqlSession session = Template.getSqlSession();
		
		List<Computer> computer = computerDao.findCategory(session, category);
		
		return computer;
	}

	public List<Computer> findByKeyword(String keyword) {
		
		SqlSession session = Template.getSqlSession();
		
		List<Computer> computer = computerDao.findByKeyword(session, keyword);
		
		return computer;
	}

	public int update(ComputerDTO cd) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = computerDao.update(session, cd);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
		
	}

	public int delete(Computer computer) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = computerDao.delete(session, computer);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

}
