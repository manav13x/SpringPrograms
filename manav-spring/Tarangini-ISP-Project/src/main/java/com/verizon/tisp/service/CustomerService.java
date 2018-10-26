package com.verizon.tisp.service;

import java.time.LocalDate;
import java.util.List;

import com.verizon.tisp.model.Customer;

public interface CustomerService {

	Customer getCustomerById(long cId);
	Customer addCustomer(Customer customer);
	
	}
