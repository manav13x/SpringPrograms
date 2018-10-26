package com.verizon.jhd.model.composition;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="halltickets")
public class HallTicket {
	
	@Id
	private String halltckNum;
	private String candidateName;
	private String ExamTitle;
	@Embedded
	private Identification identity;
	
	public HallTicket() {
		
	}

	public HallTicket(String halltckNum, String candidateName, String examTitle, Identification identity) {
		super();
		this.halltckNum = halltckNum;
		this.candidateName = candidateName;
		ExamTitle = examTitle;
		this.identity = identity;
	}

	public String getHalltckNum() {
		return halltckNum;
	}

	public void setHalltckNum(String halltckNum) {
		this.halltckNum = halltckNum;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getExamTitle() {
		return ExamTitle;
	}

	public void setExamTitle(String examTitle) {
		ExamTitle = examTitle;
	}

	public Identification getIdentity() {
		return identity;
	}

	public void setIdentity(Identification identity) {
		this.identity = identity;
	}
	

}
