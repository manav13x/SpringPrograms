package com.verizon.emp.restapi;

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

import com.verizon.emp.model.Emplyoee;
import com.verizon.emp.service.EmplyoeeService;

@RestController
@CrossOrigin
@RequestMapping("/emplyoees")
public class EmplyoeeApi {

	@Autowired
	private EmplyoeeService service;

	@GetMapping
	public ResponseEntity<List<Emplyoee>> getAllEmplyoees() {
		return new ResponseEntity<>(service.getAllEmplyoees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emplyoee> getEmplyoeeById(@PathVariable("id") long emplyoeeId) {

		ResponseEntity<Emplyoee> resp;
		Emplyoee c = service.getEmplyoeeById(emplyoeeId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmplyoeeAction(@PathVariable("id") long emplyoeeId) {
		ResponseEntity<Void> resp = null;
		boolean isDeleted = service.deleteEmplyoee(emplyoeeId);
		if (!isDeleted)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Emplyoee> addEmplyoeeAction(@RequestBody Emplyoee emplyoee) {
		ResponseEntity<Emplyoee> resp = null;
		if (service.existsByEmailId(emplyoee.getEmailId())) {
			resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		if (service.existsByMobileNumber(emplyoee.getMobileNumber())) {
			resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			Emplyoee c = service.addEmplyoee(emplyoee);
			if (c == null)
				resp = new ResponseEntity<Emplyoee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Emplyoee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Emplyoee> updateEmplyoeeAction(@RequestBody Emplyoee emplyoee) {
		ResponseEntity<Emplyoee> resp = null;
		Emplyoee c = service.getEmplyoeeById(emplyoee.getEmpId());
		if (!emplyoee.getEmailId().equals(c.getEmailId())) {
			if (service.existsByEmailId(emplyoee.getEmailId())) {
				resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
		}
		if (!emplyoee.getMobileNumber().equals(c.getMobileNumber())) {
			if (service.existsByMobileNumber(emplyoee.getMobileNumber())) {
				resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
		}
		if (resp == null) {
			c = service.updateEmplyoee(emplyoee);
			if (c == null)
				resp = new ResponseEntity<Emplyoee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Emplyoee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Emplyoee>> getAllEmplyoees(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {
		// List<Emplyoee> results = null;
		ResponseEntity<List<Emplyoee>> resp = null;
		switch (fieldBy) {
		case "mobileNumber":
			Emplyoee cbyMobNum = service.findByMobileNumber(searchValue);
			if (cbyMobNum != null) {
				resp = new ResponseEntity<List<Emplyoee>>(Collections.singletonList(cbyMobNum), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Emplyoee>>(HttpStatus.NOT_FOUND);
			}
			break;
		case "emailId":
			Emplyoee cbyEmail = service.findByEmailId(searchValue);
			if (cbyEmail != null) {
				resp = new ResponseEntity<List<Emplyoee>>(Collections.singletonList(cbyEmail), HttpStatus.OK);
			} else
				resp = new ResponseEntity<List<Emplyoee>>(HttpStatus.NOT_FOUND);
			break;
		case "lastName":
			List<Emplyoee> results = service.findAllByLastName(searchValue);
			if (results != null && results.size() != 0) {
				resp = new ResponseEntity<List<Emplyoee>>(results, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Emplyoee>>(results, HttpStatus.NOT_FOUND);
			}
			break;
		case "dept":
			List<Emplyoee> resultd = service.findAllByDept(searchValue.toString());
			if (resultd != null && resultd.size() != 0) {
				resp = new ResponseEntity<List<Emplyoee>>(resultd, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Emplyoee>>(resultd, HttpStatus.NOT_FOUND);
			}
			break;
		case "dateOfBirth":
			List<Emplyoee> resultdob = service.findAllByDateOfBirth(LocalDate.parse(searchValue));
			if (resultdob != null && resultdob.size() != 0) {
				resp = new ResponseEntity<List<Emplyoee>>(resultdob, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Emplyoee>>(resultdob, HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<List<Emplyoee>>(HttpStatus.BAD_REQUEST);
			break;
		}
		return resp;
	}
}
