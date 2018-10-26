package com.verizon.bsa.model;

public class Book {
	
	private int bcode;
	private String title;
	private double price;
	private String category;
	private String type;
	
	public Book(){
		
	}
	public Book(int bcode, String title, double price, String category, String type) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.price = price;
		this.category = category;
		this.type = type;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
