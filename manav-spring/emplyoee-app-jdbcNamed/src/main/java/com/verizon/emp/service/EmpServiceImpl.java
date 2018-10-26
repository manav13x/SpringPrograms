package com.verizon.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.emp.dao.EmplyoeeDao;
import com.verizon.emp.model.Emplyoee;
@Service
public class EmpServiceImpl implements EmpService{

	
	@Autowired
	private EmplyoeeDao EmplyoeeDao;
	@Override
	public Emplyoee addEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
		return EmplyoeeDao.addEmplyoee(Emplyoee);
	}

	@Override
	public Emplyoee updateEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
		return EmplyoeeDao.updateEmplyoee(Emplyoee);
	}

	@Override
	public Emplyoee getEmplyoeeById(int bcode) {
		// TODO Auto-generated method stub
		return EmplyoeeDao.getEmplyoeeById(bcode);
	}

	@Override
	public boolean deleteEmplyoeeById(int bcode) {
		// TODO Auto-generated method stub
		return EmplyoeeDao.deleteEmplyoeeById(bcode);
	}

	@Override
	public List<Emplyoee> getAllEmplyoees() {
		// TODO Auto-generated method stub
		return EmplyoeeDao.getAllEmplyoees();
	}

}
