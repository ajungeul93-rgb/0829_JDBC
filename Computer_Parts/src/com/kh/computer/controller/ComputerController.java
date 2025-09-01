package com.kh.computer.controller;

import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.vo.Computer;

public class ComputerController {

	public void addPcPart(String partId, String category, int price, String manufacturer) {
	
		Computer com = new Computer(partId, category, price, manufacturer);
		
		int result = new ComputerDao().addPcPart(com);
		
	}

}
