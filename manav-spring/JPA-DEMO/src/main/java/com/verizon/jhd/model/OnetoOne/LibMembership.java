package com.verizon.jhd.model.OnetoOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LibMembership {
	
	@Id
	private String accNum;
	private int numOfBooks;
	
	@OneToOne
	@JoinColumn(name="accHolderId")
	private Student accHolder;	//to which person acnt related to
	
	public LibMembership() {
		
	}

	public LibMembership(String accNum, int numOfBooks) {
		super();
		this.accNum = accNum;
		this.numOfBooks = numOfBooks;
		
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public int getNumOfBooks() {
		return numOfBooks;
	}

	public void setNumOfBooks(int numOfBooks) {
		this.numOfBooks = numOfBooks;
	}

	public Student getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Student accHolder) {
		this.accHolder = accHolder;
	}
	
	
	


}
