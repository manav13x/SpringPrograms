package com.verizon.jhd.model.OnetoOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students")

public class Student {
	
	@Id
	private int studentId;
	private String studentname;
	private String branch;
	
	@OneToOne(mappedBy="accHolder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private LibMembership libAccount;
	
	public Student() {
		
	}

	public Student(int studentId, String studentname, String branch) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.branch = branch;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LibMembership getLibAccount() {
		return libAccount;
	}

	public void setLibAccount(LibMembership libAccount) {
		this.libAccount = libAccount;
	}

	
	
	
	
	

}
