package com.verizon.tisp.restapi;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tisp.model.Customer;

import com.verizon.tisp.model.Services;
import com.verizon.tisp.service.CustomerService;
import com.verizon.tisp.service.ServiceImpl;
import com.verizon.tisp.service.ServicesI;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerApi {

	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private ServiceImpl iservice;
	
	

	@GetMapping
	public ResponseEntity<List<Services>> getAllServices() {
		return new ResponseEntity<>(iservice.getAllServices(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long cId) {

		ResponseEntity<Customer> resp;
		Customer c = cservice.getCustomerById(cId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Customer> addEmplyoeeAction(@RequestBody Customer customer) {
		ResponseEntity<Customer> resp = null;
		if (resp == null) {
			Customer c = cservice.addCustomer(customer);
			if (c == null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return resp;
	}


	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Services>> getAllCustomers(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {
		ResponseEntity<List<Services>> resp = null;
		switch (fieldBy) {
		case "netspeed":
			List<Services> results = iservice.findAllByNetSpeed(Double.parseDouble(searchValue));
			if (results != null) {
				resp = new ResponseEntity<List<Services>>(results, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Services>>(results,HttpStatus.NOT_FOUND);
			}
			break;
		case "charges":
			List<Services> results1 = iservice.findAllByCharges(Double.parseDouble(searchValue));
			if (results1 != null) {
				resp = new ResponseEntity<List<Services>>(results1, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Services>>(results1,HttpStatus.NOT_FOUND);
			}
			break;
		case "maxusage":
			List<Services> results2 = iservice.findAllByNetSpeed(Double.parseDouble(searchValue));
			if (results2 != null) {
				resp = new ResponseEntity<List<Services>>(results2, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Services>>(results2,HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<List<Services>>(HttpStatus.BAD_REQUEST);
			break;
		}
		return resp;
	}
}
