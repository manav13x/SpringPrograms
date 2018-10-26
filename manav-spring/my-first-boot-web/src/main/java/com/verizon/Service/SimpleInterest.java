package com.verizon.Service;

import com.verizon.model.Interest;

public interface SimpleInterest {
	double showInterest(Interest interest);
	double getPayableAmount(Interest interest);
}
