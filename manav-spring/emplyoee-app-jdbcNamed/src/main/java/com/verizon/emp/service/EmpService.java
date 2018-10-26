package com.verizon.emp.service;

import java.util.List;

import com.verizon.emp.model.Emplyoee;

public interface EmpService {

	Emplyoee addEmplyoee(Emplyoee Emplyoee);
	Emplyoee updateEmplyoee(Emplyoee Emplyoee);
	Emplyoee getEmplyoeeById(int empid);
	boolean deleteEmplyoeeById(int empid);
	List<Emplyoee> getAllEmplyoees();
}
