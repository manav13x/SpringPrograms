package com.verizon.jhd.model;

import javax.persistence.Transient;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pin")
	private int personalIdentificationNumber;
	@Column(name = "fnm")
	private String firstName;
	@Column(name = "lmn")
	private String lastName;
	@Transient
	private String fullName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private boolean isMarried;
	@Column(name = "dob")
	private LocalDate dateOfbirth;

	public Person() {
	}

	public Person(String firstName, String lastName, Gender gender,	boolean isMarried, LocalDate dateOfbirth) {		
		super();		
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.isMarried=isMarried;
		this.dateOfbirth=dateOfbirth;
		
	}

	public int getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(int personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	
	
}
