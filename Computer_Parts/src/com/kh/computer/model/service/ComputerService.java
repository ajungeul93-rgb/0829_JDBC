package com.kh.computer.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.vo.Computer;

public class ComputerService {
	private Connection conn = null;
	
	public ComputerService() {
		conn = JDBCTemplate.getConnection();
	}

	public int addPcPart(ComputerDTO cd) {
		
		int result = 0;
		
		Computer computer = new ComputerDao().addPcPart(conn,cd);
		return 0;
	}

}
