package com.verizon.emp.model;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document(collection="emplyoees")
public class Emplyoee {

	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long empId;
	
	@NotEmpty(message="firstName cannot be empty")
	@Size(min=5,max=15,message="firstName must be of 5 to 15 chars")
	private String firstName;
	
	@NotEmpty(message="lasstName cannot be empty")
	@Size(min=5,max=15,message="lastName must be of 5 to 15 chars")
	private String lastName;
	
	@NotNull(message="cannot be empty")
	//@Digits(integer=10, fraction=0)
	private double basic;

	@NotNull(message="cannot be empty")
	//@Digits(integer=5, fraction=0)
	private double hra;
	

	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Date of Birth cannot be blank")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message="Email ID cannot be null")
	@Email(message="Invalid Email Id")
	private String emailId;
	
	@NotEmpty(message="mobile no cannot be null")
	@Pattern(regexp="\\d{10}",message="mobile number can be only of 10 digits")
	private String mobileNumber;
	private String gender;
	//@NotEmpty(message="Dept cannot be empty")
	//@Enumerated(EnumType.STRING)
	private String dept;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
