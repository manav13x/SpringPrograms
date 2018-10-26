package com.verizon.Service;

import com.verizon.model.Employee;

public interface EmployeeManage {
	public double calculateHRA(Employee employee);
	public double calculateTA(Employee employee);
	public double settNetPay(Employee employee);
}	
