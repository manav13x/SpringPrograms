package com.verizon.jhd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	private int bcode;
	private  String title;
	private double price;
	
	public Book(){
		
	}

	public Book(int bcode, String title, double price) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.price = price;
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
	

}
