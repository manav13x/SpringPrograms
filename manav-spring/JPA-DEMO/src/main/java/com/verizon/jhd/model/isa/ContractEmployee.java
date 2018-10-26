package com.verizon.jhd.model.isa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("cemp")
//@Table(name = "CEmps")
@Table(name = "CEmpsOnly")
public class ContractEmployee extends Emp {
	@Column(name = "cdur")
	private int contractDuration;

	public ContractEmployee() {
	}

	public ContractEmployee(int empId, String ename, double basic, int contractDuration) {
		super(empId, ename, basic);
		this.contractDuration = contractDuration;
		// TODO Auto-generated constructor stub
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
}
