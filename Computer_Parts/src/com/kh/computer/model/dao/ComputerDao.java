package com.kh.computer.model.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.kh.computer.model.vo.Computer;

public class ComputerDao {

	public int addPcPart(Computer com) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "ISERT " + "INTO " + "TB_PC_PARTS " + "VALUES " + "(" + "SEQ_";
		
		return result;
	}

}
