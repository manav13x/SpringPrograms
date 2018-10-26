package com.verizon.mongoDemo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="vehicles")
public class Vehicles {
	//iD SHOULD COME FROM SPRING DATA NOT FROM JPA TO WORK WITH NO SQL
	@Id
	private int vCode;
	private String vName;
	private double vPrice;
	
	public Vehicles(){
	}

	public Vehicles(int vCode, String vName, double vPrice) {
		super();
		this.vCode = vCode;
		this.vName = vName;
		this.vPrice = vPrice;
	}

	public int getvCode() {
		return vCode;
	}

	public void setvCode(int vCode) {
		this.vCode = vCode;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public double getvPrice() {
		return vPrice;
	}

	public void setvPrice(double vPrice) {
		this.vPrice = vPrice;
	}

	@Override
	public String toString() {
		return "Item [vCode=" + vCode + ", vName=" + vName + ", vPrice=" + vPrice + "]";
	}
	
	
	
}
