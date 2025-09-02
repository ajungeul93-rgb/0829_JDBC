package com.kh.computer.controller;

import java.util.List;

import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.vo.Computer;

public class ComputerController {

	public int addPcPart(String partId, String category, int price, String manufacturer) {
	
		Computer com = new Computer(partId, category, price, manufacturer);
		
		int result = new ComputerDao().addPcPart(com);
		
		return result;
		
	}
	
	public List<Computer> viewAll(){
		
		List<Computer> parts = new ComputerDao().viewAll();
		
		return parts;
		
	}
	
	public Computer findCategory(String category) {
		
		Computer computer = new ComputerDao().findCategory(category);
		
		return computer;
	}

	public List<Computer> findByKeyword(String keyword) {

		List<Computer> parts = new ComputerDao().findByKeyword(keyword);
		
		return parts;
	}

}
