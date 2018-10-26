package com.verizon.jhp.model.isa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name="PLoan")
public class PersonalLoan extends Loan{
	private double anumInc;
	public PersonalLoan() {
		
	}
	
	public PersonalLoan(int loanId, double amount, int termcount,double anumInc) {
		super(loanId, amount, termcount);
		// TODO Auto-generated constructor stub
		this.anumInc=anumInc;
	}

	public double getAnumInc() {
		return anumInc;
	}

	public void setAnumInc(double anumInc) {
		this.anumInc = anumInc;
	}

}
