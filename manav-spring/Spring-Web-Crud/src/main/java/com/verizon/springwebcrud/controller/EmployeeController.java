package com.verizon.springwebcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.springwebcrud.model.Employee;
import com.verizon.springwebcrud.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;
	
	@GetMapping("/listEmps")
	public ModelAndView listEmployees(){
		return new ModelAndView("empList","emps",empService.listEmployees());
	}
	@GetMapping("/addEmp")
	public ModelAndView addEmployee(){
		
		return new ModelAndView("addEmp","emp",new Employee());
	}
	@PostMapping("/addEmp")
	private String doAddEmployee(@ModelAttribute Employee emp){
		empService.addEmployee(emp);
		return "redirect:/listEmps";
	}
}
