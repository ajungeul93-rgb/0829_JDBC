package com.kh.computer.model.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.vo.Computer;

public class ComputerDao {
	

	public int addPcPart(SqlSession session, Computer computer) {
		
		return session.insert("computerMapper.addPcPart", computer);
		
	}
	
	public List<Computer> viewAll(SqlSession session){
		
		return session.selectList("computerMapper.viewAll");
		
	}
	
	
	public List<Computer> findCategory(SqlSession session, String category) {
		
		return session.selectList("computerMapper.findCategory", category);
		
	}

	public List<Computer> findByKeyword(SqlSession session, String keyword) {

		return session.selectList("computerMapper.findByKeyword", keyword);
		
	}

	public int update(SqlSession session, ComputerDTO cd) {
		
		return session.update("computerMapper.update", cd);
		
	}

	public int delete(SqlSession session, Computer computer) {
		
		return session.delete("computerMapper.delete", computer);
		
	}

}
