package com.verizon.emp.restapi;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.verizon.emp.model.Emplyoee;
import com.verizon.emp.service.EmpService;
import com.verizon.emp.service.EmpServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/emplyoees")
public class EmplyoeeAPI {
	
	@Autowired
	private EmpService emplyoeeService;
	
	@GetMapping
	public ResponseEntity<List<Emplyoee>> listEmplyoeesAction(){
		return new ResponseEntity<List<Emplyoee>>
				(emplyoeeService.getAllEmplyoees(),HttpStatus.OK);
	}
	@GetMapping("/{empid}")
	public ResponseEntity<Emplyoee> getEmplyoeeAction(@PathVariable("empid")int bcode){
		ResponseEntity<Emplyoee> resp=null;
		Emplyoee b = emplyoeeService.getEmplyoeeById(bcode);
		if(b==null)
				resp =  new ResponseEntity<Emplyoee>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<Emplyoee>(b,HttpStatus.OK);
		return resp;
	}
	@DeleteMapping("/{empid}")
	public ResponseEntity<Void> deleteEmplyoeeAction(@PathVariable("empid")int bcode){
		ResponseEntity<Void> resp=null;
		boolean isDeleted = emplyoeeService.deleteEmplyoeeById(bcode);
		if(!isDeleted)
				resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}
	@PostMapping
	public ResponseEntity<Emplyoee> addEmplyoeeAction(@RequestBody Emplyoee Emplyoee){
		ResponseEntity<Emplyoee> resp = null;
		Emplyoee = emplyoeeService.addEmplyoee(Emplyoee);
		if(Emplyoee!=null)
			resp = new ResponseEntity<>(Emplyoee,HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return resp;
	}
	@PutMapping
	public ResponseEntity<Emplyoee> updateEmplyoeeAction(@RequestBody Emplyoee Emplyoee){
		ResponseEntity<Emplyoee> resp = null;
		if(emplyoeeService.getEmplyoeeById(Emplyoee.getEmpid())==null){
			resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			Emplyoee = emplyoeeService.updateEmplyoee(Emplyoee);
			if(Emplyoee!=null)
					resp = new ResponseEntity<>(Emplyoee,HttpStatus.OK);
			else
				resp = new ResponseEntity<>(Emplyoee,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
