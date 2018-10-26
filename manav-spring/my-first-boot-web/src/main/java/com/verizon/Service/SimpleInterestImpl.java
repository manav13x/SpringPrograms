package com.verizon.Service;

import org.springframework.stereotype.Service;

import com.verizon.model.Interest;

@Service
public class SimpleInterestImpl implements SimpleInterest {

	@Override
	public double showInterest(Interest interest) {
		return ((interest.getPrincipal()*interest.getRateOfInterest()*interest.getTimePeriod())/100);
	}

	@Override
	public double getPayableAmount(Interest interest) {
		return interest.getPrincipal()+interest.getSimpleInterest();
	}

}
