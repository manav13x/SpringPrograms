package com.verizon.springwebcrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springwebcrud.dao.IEmployeeRepo;
import com.verizon.springwebcrud.model.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepo empRepo;

	@Transactional
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public void deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
			empRepo.deleteById(empId);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = empRepo.findById(empId);
		Employee emp = opt.isPresent()?opt.get():null;
		return emp;
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
