package com.nexus.bnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cId;
	
	@NotEmpty(message="UserName Cannot Be Empty")
	private String uName;
	
	@NotEmpty(message="Email Id Cannot Be Empty")
	@Email(message="Please Enter a Valid Email Id")
	private String emailId;
	
	@NotEmpty(message="Password Cannot Be Empty")
	private String pwd;
	
	@NotEmpty(message="Mobile no cannot be null")
	@Pattern(regexp="\\d{10}",message="mobile number can be only of 10 digits")
	@Column(name="mNum")
	private String mobileNumber;
	
	private String address;

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
 }
