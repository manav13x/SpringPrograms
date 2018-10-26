package com.verizon.emp.model;

public class Emplyoee {
	
	private int empid;
	private String ename;
	private double basic;
	private double hra;
	private String dept;
	
	public Emplyoee(){
		
	}

	public Emplyoee(int empid, String ename, double basic, double hra, String dept) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
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
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	

}
