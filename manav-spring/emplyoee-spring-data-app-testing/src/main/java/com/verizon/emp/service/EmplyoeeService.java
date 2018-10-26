package com.verizon.emp.service;

import java.time.LocalDate;
import java.util.List;

import com.verizon.emp.model.Emplyoee;

public interface EmplyoeeService {

	Emplyoee getEmplyoeeById(long emplyoeeId);
	List<Emplyoee> getAllEmplyoees();
	Emplyoee addEmplyoee(Emplyoee emplyoee);
	Emplyoee updateEmplyoee(Emplyoee emplyoee);
	boolean deleteEmplyoee(long emplyoeeId);
	
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	Emplyoee);
	
	Emplyoee findByMobileNumber(String mobileNumber);
	Emplyoee findByEmailId(String emailId);
	
	List<Emplyoee> findAllByLastName(String lastName);
	List<Emplyoee> findAllByDept(String dept);
	List<Emplyoee> findAllByDateOfBirth(LocalDate dateOfBirth);
	
	
	}
