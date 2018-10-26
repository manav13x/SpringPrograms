package com.verizon.tisp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name="services")
public class Services {
	
	@Id
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotNull(message="cannot be empty")
	private double netSpeed;
	@NotNull(message="cannot be empty")
	private  double maxUsage;
	@NotNull(message="cannot be empty")
	private double charges;
	public double getNetSpeed() {
		return netSpeed;
	}
	public void setNetSpeed(double netSpeed) {
		this.netSpeed = netSpeed;
	}
	public double getMaxUsage() {
		return maxUsage;
	}
	public void setMaxUsage(double maxUsage) {
		this.maxUsage = maxUsage;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	
	
}
