package com.verizon.model;

public class Interest {
	
	private double principal;
	private double rateOfInterest;
	private double timePeriod;
	private double simpleInterest;
	private double repayableAmount;

	public Interest() {

	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}

	public double getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}

	public double getRepayableAmount() {
		return repayableAmount;
	}

	public void setRepayableAmount(double repayableAmount) {
		this.repayableAmount = repayableAmount;
	}

}
