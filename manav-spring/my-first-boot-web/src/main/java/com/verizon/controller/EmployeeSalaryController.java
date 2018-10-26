package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.Service.EmployeeManage;
import com.verizon.model.Book;
import com.verizon.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeSalaryController {

	@Autowired
	private EmployeeManage empserv;
	
	@GetMapping
	public ModelAndView defaultEmpSalaryAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("empdetailsPage");
		
		mv.addObject("emp2", new Employee());
		mv.addObject("posibDept", new String[] { "Networks", "Database", "HR", "Cleaning" });
		mv.addObject("posibGender", new String[] { "Male", "Female", "Other" });

		return mv;
	}
	
	@PostMapping
	public ModelAndView submitSalaryAction(
			@ModelAttribute("emp2") Employee emp) {
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("showSalarySlipPage");
		
		emp.setHra(empserv.calculateHRA(emp));
		emp.setTa(empserv.calculateTA(emp));
		emp.setNetPay(empserv.settNetPay(emp));
		
		mv.addObject("salary",emp);		
		
		return mv;
		
	}
}
