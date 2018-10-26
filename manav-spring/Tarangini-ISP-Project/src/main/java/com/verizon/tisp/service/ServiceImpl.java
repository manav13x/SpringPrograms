package com.verizon.tisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tisp.dao.ServicesRepository;
import com.verizon.tisp.model.Services;

@Service
public class ServiceImpl implements ServicesI{
	
	@Autowired 
	ServicesRepository serR;

	@Override
	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		return serR.findAll();
	}

	@Override
	public List<Services> findAllByCharges(Double charges) {
		// TODO Auto-generated method stub
		return serR.findAllByCharges(charges);
	}

	@Override
	public List<Services> findAllByNetSpeed(Double netspeed) {
		// TODO Auto-generated method stub
		return serR.findAllByNetSpeed(netspeed);
	}

	@Override
	public List<Services> findAllByMaxUsage(Double maxusage) {
		// TODO Auto-generated method stub
		return serR.findAllByMaxUsage(maxusage);
	}

}
