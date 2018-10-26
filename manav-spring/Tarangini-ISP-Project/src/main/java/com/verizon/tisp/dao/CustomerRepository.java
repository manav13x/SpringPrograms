package com.verizon.tisp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.verizon.tisp.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	}
