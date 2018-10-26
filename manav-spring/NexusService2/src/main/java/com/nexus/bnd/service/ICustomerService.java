package com.nexus.bnd.service;

import java.util.List;

import com.nexus.bnd.model.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomer();
	Customer getCustomerById(long cId);
	Customer addCustomer(Customer c);
	boolean deleteCustomer(long cId);
	Customer updateCustomer(Customer c);
	
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	emailId);
	
	Customer findByMobileNumber(String mobileNumber);
	Customer findByEmailId(String emailId);
	
}
