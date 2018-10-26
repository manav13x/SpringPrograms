package com.verizon.mongoDemo.service;

import java.util.List;

import com.verizon.mongoDemo.model.Vehicles;

public interface VehicleService {
	public void addVehicle(Vehicles item);
	public void removeVehicle(int vCode);
	public  void updateVehicle(Vehicles item);
	public Vehicles getVehicle(int vCode);
	public List<Vehicles> getVehicles();
	public boolean exists(int vCode);
}
