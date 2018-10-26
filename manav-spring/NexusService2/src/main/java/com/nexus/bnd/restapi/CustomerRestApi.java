package com.nexus.bnd.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.bnd.model.Customer;
import com.nexus.bnd.service.ICustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerRestApi {

	@Autowired
	ICustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCust()
	{
		return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Customer> addCust(@RequestBody Customer customer)
	{
		ResponseEntity<Customer> resp = null;
		if(service.existsByEmailId(customer.getEmailId()))
			resp = new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
		if(service.existsByMobileNumber(customer.getMobileNumber()))
			resp =  new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
		if(resp==null)
		{
			Customer c = service.addCustomer(customer);
			if(c==null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
			resp =  new ResponseEntity(c,HttpStatus.OK);
		}
			return resp;
	}
}
