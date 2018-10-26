package com.verizon.emp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.emp.dao.EmplyoeeRepository;
import com.verizon.emp.model.Emplyoee;
@Service
public class EmplyoeeServiceImpl implements EmplyoeeService {
	@Autowired
	private EmplyoeeRepository EmplyoeeRepo;
	
	@Override
	public Emplyoee getEmplyoeeById(long empId) {
		// TODO Auto-generated method stub
		Emplyoee emplyoee = null;/*
		if(EmplyoeeRepo.existsById(EmplyoeeId))
		{
			Emplyoee = EmplyoeeRepo.findById(EmplyoeeId).get();
		}*/
		//causes data base to be hit twice
		Optional<Emplyoee> optEmplyoee =  EmplyoeeRepo.findById(empId);
		if(optEmplyoee.isPresent()){
			emplyoee =  optEmplyoee.get();
		}
		return emplyoee;
	}

	@Override
	public List<Emplyoee> getAllEmplyoees() {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findAll();
	}

	@Override
	public Emplyoee addEmplyoee(Emplyoee emplyoee) {
		return EmplyoeeRepo.save(emplyoee);
	}

	@Override
	public Emplyoee updateEmplyoee(Emplyoee emplyoee) {
		return EmplyoeeRepo.save(emplyoee);
	}

	@Override
	public boolean deleteEmplyoee(long empId) {
		boolean isDeleted=false;
		if(EmplyoeeRepo.existsById(empId)){
			EmplyoeeRepo.deleteById(empId);
			isDeleted=true;
		}
		
		return isDeleted;
	}
	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		return EmplyoeeRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public boolean existsByEmailId(String Emplyoee) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.existsByEmailId(Emplyoee);
	}

	@Override
	public Emplyoee findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Emplyoee findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findByEmailId(emailId);
	}

	@Override
	public List<Emplyoee> findAllByLastName(String lastName) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findAllByLastName(lastName);
	}
	@Override
	public List<Emplyoee> findAllByDept(String dept) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findAllByDept(dept);
	}

	@Override
	public List<Emplyoee> findAllByDateOfBirth(LocalDate dateOfBirth) {
		// TODO Auto-generated method stub
		return EmplyoeeRepo.findAllByDateOfBirth(dateOfBirth);
	}
}
