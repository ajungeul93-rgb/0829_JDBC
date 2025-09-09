package com.kh.computer.controller;

import java.util.List;

import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.service.ComputerService;
import com.kh.computer.model.dao.ComputerDao;
import com.kh.computer.model.vo.Computer;

public class ComputerController {

	public int addPcPart(String partName, String category, int price, String manufacturer) {
	
		Computer computer = new Computer(partName, category, price, manufacturer);
		
		int result = new ComputerService().addPcPart(computer);
		
		return result;
		
	}
	
	public List<Computer> viewAll(){
		
		List<Computer> parts = new ComputerService().viewAll();
		
		return parts;
		
	}
	
	public Computer findCategory(String category) {
		
		Computer computer = new ComputerService().findCategory(category);
		
		return computer;
	}

	public List<Computer> findByKeyword(String keyword) {

		List<Computer> parts = new ComputerService().findByKeyword(keyword);
		
		return parts;
	}

	public int update(String partName, String category, String manufacturer) {
		
		ComputerDTO cd = new ComputerDTO(partName, category, manufacturer);
		
		int result = new ComputerService().update(cd);
		
		return result;
	}
	
	public int delete(int partId, String partName) {
		
		Computer computer = new Computer();
		computer.setPartId(partId);
		computer.setPartName(partName);
		
		int result = new ComputerService().delete(computer);
		
		return result;
	}

	
	

}
