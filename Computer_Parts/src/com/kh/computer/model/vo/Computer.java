package com.kh.computer.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Computer {
	
	private int partId;
	private String partName;
	private String category;
	private int price;
	private String manufacturer;
	private Date purchaseDate;
	
	public Computer() {
		super();
	}

	public Computer(String partName, String category, int price, String manufacturer) {
		super();
		this.partName = partName;
		this.category = category;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public Computer(int partId, String partName, String category, int price, String manufacturer, Date purchaseDate) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.category = category;
		this.price = price;
		this.manufacturer = manufacturer;
		this.purchaseDate = purchaseDate;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Computer [partId=" + partId + ", partName=" + partName + ", category=" + category + ", price=" + price
				+ ", manufacturer=" + manufacturer + ", purchaseDate=" + purchaseDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, manufacturer, partId, partName, price, purchaseDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return Objects.equals(category, other.category) && Objects.equals(manufacturer, other.manufacturer)
				&& partId == other.partId && Objects.equals(partName, other.partName) && price == other.price
				&& Objects.equals(purchaseDate, other.purchaseDate);
	}

	
}
