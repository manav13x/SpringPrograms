package com.verizon.service;

public class EligibilityService {
	
	public boolean isEligibleToVote(int age){
		boolean isEligible = false;
		if(age>=18 && age<=100){
			isEligible = true;
		}
		return isEligible;
	}

}
