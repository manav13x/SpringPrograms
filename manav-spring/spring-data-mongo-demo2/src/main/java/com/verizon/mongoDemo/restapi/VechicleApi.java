package com.verizon.mongoDemo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.mongoDemo.model.Vehicles;
import com.verizon.mongoDemo.service.VehicleServiceImpl;

@RestController
@RequestMapping("/vehicles")
public class VechicleApi {

	@Autowired
	private VehicleServiceImpl service;

	@GetMapping
	public ResponseEntity<List<Vehicles>> getAllVehicles(){
		ResponseEntity<List<Vehicles>> resp = null;
		List<Vehicles> items = service.getVehicles();
		if(items!=null && items.size()>0)
			resp = new ResponseEntity<List<Vehicles>>(items,HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Vehicles>>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@GetMapping("{icode}")
	public ResponseEntity<Vehicles> getVehicle(@PathVariable("icode") int icode){
		ResponseEntity<Vehicles> resp = null;
		Vehicles item = service.getVehicle(icode);
		if(item!=null)
			resp = new ResponseEntity<>(item,HttpStatus.OK);
		else
			resp= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Vehicles> additem(@RequestBody Vehicles item){
		ResponseEntity<Vehicles> resp = null;
	
		if(item!=null && !service.exists(item.getvCode())){
			service.addVehicle(item);
			resp = new ResponseEntity<Vehicles>(item,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<Vehicles>(HttpStatus.CONFLICT);
		
		}
		return resp;
	}
	@PutMapping
	public ResponseEntity<Vehicles> updateitem(@RequestBody Vehicles item){
		ResponseEntity<Vehicles> resp = null;
	
		if(item!=null){
			service.updateVehicle(item);
			resp = new ResponseEntity<Vehicles>(item,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
		
		}
		return resp;
	}
@DeleteMapping("{vcode}")
public ResponseEntity<Void> deleteitem(@PathVariable("vcode") int vcode){
	ResponseEntity<Void> resp = null;

	if(service.exists(vcode)){
		service.removeVehicle(vcode);
		resp = new ResponseEntity<>(HttpStatus.OK);
	}
	else
	{
		resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	return resp;
}
}