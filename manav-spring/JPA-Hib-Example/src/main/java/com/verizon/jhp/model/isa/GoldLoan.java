package com.verizon.jhp.model.isa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GLoan")
public class GoldLoan extends Loan{
	private Double goldWtIngm;
	
	public GoldLoan() {
		
	}

	public GoldLoan(int loanId, double amount, int termcount,double goldWtIngm) {
		super(loanId, amount, termcount);
		// TODO Auto-generated constructor stub
		this.goldWtIngm=goldWtIngm;
	}

	public Double getGoldWtIngm() {
		return goldWtIngm;
	}

	public void setGoldWtIngm(Double goldWtIngm) {
		this.goldWtIngm = goldWtIngm;
	}
	
}
