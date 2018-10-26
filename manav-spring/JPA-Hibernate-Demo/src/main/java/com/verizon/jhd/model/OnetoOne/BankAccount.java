package com.verizon.jhd.model.OnetoOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {

		@Id
		private String accNum;
		private String BankName;
		private String ifscCode;
		
		@OneToOne
		@JoinColumn(name="accHolderId")
		private Emp accHolder;	//to which person acnt related to

			public BankAccount() {
				
			}

			public BankAccount(String accNum, String bankName, String ifscCode) {
				super();
				this.accNum = accNum;
				BankName = bankName;
				this.ifscCode = ifscCode;
			}

			public String getAccNum() {
				return accNum;
			}

			public void setAccNum(String accNum) {
				this.accNum = accNum;
			}

			public String getBankName() {
				return BankName;
			}

			public void setBankName(String bankName) {
				BankName = bankName;
			}

			public String getIfscCode() {
				return ifscCode;
			}

			public void setIfscCode(String ifscCode) {
				this.ifscCode = ifscCode;
			}

			public Emp getAccHolder() {
				return accHolder;
			}

			public void setAccHolder(Emp accHolder) {
				this.accHolder = accHolder;
			}
			
			
}
