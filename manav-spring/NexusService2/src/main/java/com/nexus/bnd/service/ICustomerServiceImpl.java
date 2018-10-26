package com.nexus.bnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.bnd.dao.CustomerRepository;
import com.nexus.bnd.model.Customer;
@Service
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	CustomerRepository cRepo;
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long cId) {
		// TODO Auto-generated method stub
		Customer c = null;
		Optional<Customer> opt= cRepo.findById(cId);
		if(opt.isPresent())
			c = opt.get();
		return c;
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return cRepo.save(c);
	}

	@Override
	public boolean deleteCustomer(long cId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		if(cRepo.existsById(cId))
		{
			cRepo.deleteById(cId);
			deleted=true;
		}
		return deleted;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return cRepo.save(c);
	}

	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return cRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return cRepo.existsByEmailId(emailId);
	}

	@Override
	public Customer findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return cRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Customer findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return cRepo.findByEmailId(emailId);
	}



}
