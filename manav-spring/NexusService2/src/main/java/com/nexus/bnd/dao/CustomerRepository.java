package com.nexus.bnd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.bnd.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	emailId);

	Customer findByMobileNumber(String mobileNumber);
	Customer findByEmailId(String emailId);
}
