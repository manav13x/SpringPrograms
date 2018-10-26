package com.verizon.mongoDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.mongoDemo.dao.VehicleMongoRepository;
import com.verizon.mongoDemo.model.Vehicles;
@Service
public class VehicleServiceImpl implements VehicleService {

	
	@Autowired
	private VehicleMongoRepository itemDAO;
	
	@Override
	public void addVehicle(Vehicles vec) {
		// TODO Auto-generated method stub
		itemDAO.insert(vec);
	}

	@Override
	public void removeVehicle(int vCode) {
		// TODO Auto-generated method stub
		itemDAO.deleteById(vCode);
	}

	@Override
	public void updateVehicle(Vehicles vec) {
		// TODO Auto-generated method stub
		itemDAO.save(vec);
	}

	@Override
	public Vehicles getVehicle(int vCode) {
		// TODO Auto-generated method stub
		Optional<Vehicles> opt = itemDAO.findById(vCode);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Vehicles> getVehicles() {
		// TODO Auto-generated method stub
		return itemDAO.findAll();
	}

	@Override
	public boolean exists(int vCode) {
		// TODO Auto-generated method stub
		return itemDAO.existsById(vCode);
	}

}
