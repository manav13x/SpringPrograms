package com.verizon.jhp.model.isa;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity



@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="LoanOnly")

public abstract class Loan {
	@Id
	private int loanId;
	private double amount;
	private int termcount;
	public Loan() {
		
	}
	public Loan(int loanId, double amount, int termcount) {
		super();
		this.loanId = loanId;
		this.amount = amount;
		this.termcount = termcount;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTermcount() {
		return termcount;
	}
	public void setTermcount(int termcount) {
		this.termcount = termcount;
	}
	
	
}
