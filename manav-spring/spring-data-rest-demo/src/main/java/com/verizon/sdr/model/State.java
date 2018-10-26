package com.verizon.sdr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class State {
	//we use wrapper class because primitive wont support null
	@Id
	private Long stateCode;
	private String stateName;
	private String capital;
	public Long getStateCode() {
		return stateCode;
	}
	public void setStateCode(Long stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	
}
