package com.verizon.jhd.model.association;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankaccounts")
public class BankAccount {

	@Id
	private String accNumber;
	private double bal;
	
	@OneToOne
	@JoinColumn(name="accHolderId")
	private Citizen accountHolder;

	
	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public Citizen getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Citizen accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
