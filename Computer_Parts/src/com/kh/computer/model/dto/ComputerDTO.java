package com.kh.computer.model.dto;

public class ComputerDTO {
	
	private String partName; 
	private String category;
	private int price;
	private String manufacturer;
	
	public ComputerDTO() {
		super();
	}

	public ComputerDTO(String partName, String category,int price, String manufacturer) {
		super();
		this.partName = partName;
		this.category = category;
		this.price = price;
		this.manufacturer = manufacturer;
	}
	
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
	

}
