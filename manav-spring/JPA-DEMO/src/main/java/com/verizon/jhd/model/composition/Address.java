package com.verizon.jhd.model.composition;

import javax.persistence.Embeddable;

@Embeddable 
public class Address {

	private String doorBumber;
	private String city;
	private String state;
	public Address() {
		super();
	}
	public String getDoorBumber() {
		return doorBumber;
	}
	public void setDoorBumber(String doorBumber) {
		this.doorBumber = doorBumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
