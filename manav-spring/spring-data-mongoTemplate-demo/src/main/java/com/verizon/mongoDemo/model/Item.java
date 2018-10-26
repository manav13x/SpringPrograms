package com.verizon.mongoDemo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="items")
public class Item {
	//iD SHOULD COME FROM SPRING DATA NOT FROM JPA TO WORK WITH NO SQL
	@Id
	private int iCode;
	private String iName;
	private double iPrice;
	
	public Item(){
	}

	public Item(int iCode, String iName, double iPrice) {
		super();
		this.iCode = iCode;
		this.iName = iName;
		this.iPrice = iPrice;
	}

	public int getiCode() {
		return iCode;
	}

	public void setiCode(int iCode) {
		this.iCode = iCode;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public double getiPrice() {
		return iPrice;
	}

	public void setiPrice(double iPrice) {
		this.iPrice = iPrice;
	}

	@Override
	public String toString() {
		return "Item [iCode=" + iCode + ", iName=" + iName + ", iPrice=" + iPrice + "]";
	}
	
	
	
}
