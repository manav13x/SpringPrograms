package com.verizon.jhp.model.isa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PropLoan")
public class PropertyLoan extends Loan{
	private double propMktValue;
	
	public PropertyLoan() {
		
	}

	public PropertyLoan(int loanId, double amount, int termcount,double propMktValue) {
		super(loanId, amount, termcount);
		// TODO Auto-generated constructor stub
		this.propMktValue=propMktValue;
	}

	public double getPropMktValue() {
		return propMktValue;
	}

	public void setPropMktValue(double propMktValue) {
		this.propMktValue = propMktValue;
	}
	
	

}
