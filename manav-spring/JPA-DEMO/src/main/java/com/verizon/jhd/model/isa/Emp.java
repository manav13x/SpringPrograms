package com.verizon.jhd.model.isa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("emp")
@Table(name = "AllEmps")*/
//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "Emps")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "EmpsOnly")
public class Emp {
	@Id
	private int empId;
	private String ename;
	private double basic;

	public Emp() {
	}

	public Emp(int empId, String ename, double basic) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.basic = basic;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;	}
	}