package com.verizon.jhd.model.association;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="gas_subscription")
public class GasSubscription {
	@Id
	@GeneratedValue(generator="mygen")
	@GenericGenerator(name="mygen",strategy="foreign",
	parameters={@Parameter(name="property",value="subscriber")})
	private String aadharId;
	
	@Column(name="dos")
	private LocalDate dateOfSubscription;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Citizen subscriber;

	public GasSubscription(){
		
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public LocalDate getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(LocalDate dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	public Citizen getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Citizen subscriber) {
		this.subscriber = subscriber;
	}
	
}
