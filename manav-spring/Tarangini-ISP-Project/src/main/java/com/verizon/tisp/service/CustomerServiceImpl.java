package com.verizon.tisp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tisp.dao.CustomerRepository;
import com.verizon.tisp.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository CustomerRepo;
	
	@Override
	public Customer getCustomerById(long cId) {
		// TODO Auto-generated method stub
		Customer customer = null;/*
		if(EmplyoeeRepo.existsById(EmplyoeeId))
		{
			Emplyoee = EmplyoeeRepo.findById(EmplyoeeId).get();
		}*/
		//causes data base to be hit twice
		Optional<Customer> optCustomer =  CustomerRepo.findById(cId);
		if(optCustomer.isPresent()){
			customer =  optCustomer.get();
		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return CustomerRepo.save(customer);
	}
}
