package com.verizon.jhd.model.OnetoOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrgEmployees")

public class Emp {
	
	@Id
	private int empId;
	private String ename;
	private Double basic;
	
	@OneToOne(mappedBy="accHolder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private BankAccount salaryAccount;
	
	public Emp() {
		
	}

	public Emp(int empId, String ename, Double basic) {
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

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public BankAccount getSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(BankAccount salaryAccount) {
		this.salaryAccount = salaryAccount;
	}
	
	
	
	

}
