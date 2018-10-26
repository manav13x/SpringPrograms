package com.verizon.jhd.model.association;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="citizens")
public class Citizen {
	@Id
	private String aadharId;
	private String name;
	
	@OneToOne(mappedBy="subscriber",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private GasSubscription gasSubscription;
	
	@OneToOne(mappedBy="accountHolder",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private BankAccount bankAccount;
	public GasSubscription getGasSubscription() {
		return gasSubscription;
	}
	public void setGasSubscription(GasSubscription gasSubscription) {
		this.gasSubscription = gasSubscription;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public String getAadharId() {
		return aadharId;
	}
	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
