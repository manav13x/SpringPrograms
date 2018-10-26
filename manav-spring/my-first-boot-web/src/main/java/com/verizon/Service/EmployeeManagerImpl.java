package com.verizon.Service;

import org.springframework.stereotype.Service;

import com.verizon.model.Employee;
@Service
public class EmployeeManagerImpl implements EmployeeManage {

	@Override
	public double calculateHRA(Employee employee) {
		double hold=0;
		if(employee.getExp()>=3)
			hold=0.2*employee.getBasic();
		else
			hold=0.12*employee.getBasic();
		
		return hold;
	}

	@Override
	public double calculateTA(Employee employee) {
		double hold=0;
		if(employee.getExp()>=3)
			hold=0.15*employee.getBasic();
		else
			hold=0.1*employee.getBasic();
		
		return hold;
	}

	@Override
	public double settNetPay(Employee employee) {
		return (employee.getBasic()+employee.getHra()+employee.getTa());
	}

}
