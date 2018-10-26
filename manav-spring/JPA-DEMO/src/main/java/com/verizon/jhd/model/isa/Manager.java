package com.verizon.jhd.model.isa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("memp")
//@Table(name = "MEmps")
@Table(name = "MEmpsOnly")
public class Manager extends Emp {
	private double allowence;

	public Manager() {
	}

	public Manager(int empId, String ename, double basic, double allowence) {
		super(empId, ename, basic);
		this.allowence = allowence;
	}

	public double getAllowence() {
		return allowence;
	}

	public void setAllowence(double allowence) {
		this.allowence = allowence;
	}
}