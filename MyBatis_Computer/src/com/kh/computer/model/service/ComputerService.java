package com.kh.computer.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;
import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.vo.Computer;

public class ComputerService {

	private Connection conn = null;
	private ComputerDao dao = new ComputerDao();
	
	public ComputerService() {
		this.conn = getConnection();
	}

	public int addPcPart(Computer computer) {

		int result = new ComputerDao().addPcPart(conn, computer);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public List<Computer> viewAll() {
		
		List<Computer> parts = new ComputerDao().viewAll(conn);
		close(conn);
		
		return parts;
	}

	public Computer findCategory(String category) {
		
		Computer computer = new ComputerDao().findCategory(conn, category);
		
		close(conn);
		
		return computer;
	}

	public List<Computer> findByKeyword(String keyword) {
		
		List<Computer> parts = new ComputerDao().findByKeyword(conn, keyword);
		
		close(conn);
		
		return parts;
	}

	public int update(ComputerDTO cd) {
		
		
		Computer computer = new ComputerDao().findCategory(conn, cd.getCategory());
		if(computer == null) {
			return 0;
		}
		
		int result = new ComputerDao().update(conn, cd);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

	public int delete(Computer computer) {
		
		int result = new ComputerDao().delete(conn, computer);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

}
