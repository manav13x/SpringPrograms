package com.verizon.emp.dao;

import java.util.List;

import com.verizon.emp.model.Emplyoee;

public interface EmplyoeeDao {

	Emplyoee addEmplyoee(Emplyoee Emplyoee);
	Emplyoee updateEmplyoee(Emplyoee Emplyoee);
	Emplyoee getEmplyoeeById(int empid);
	boolean deleteEmplyoeeById(int empid);
	List<Emplyoee> getAllEmplyoees();
}
