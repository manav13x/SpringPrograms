package com.verizon.emp.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.emp.model.Emplyoee;
import com.verizon.emp.model.Gender;
import com.verizon.emp.service.EmplyoeeService;

@Controller
public class EmplyoeeController {
	@Autowired
	private EmplyoeeService emplyoeeService;

	@GetMapping("/emplyoeeList")
	public ModelAndView handleEmplyoeeList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elistPage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("currentUserName", auth.getName());
		}
		mv.addObject("emplyoees", emplyoeeService.getAllEmplyoees());
		return mv;
	}

	@GetMapping("/errors")
	public String errorPage() {
		return "Invalid Credentials For this operation";
	} 

	@GetMapping("/addEmplyoee")
	public ModelAndView handleNewEmplyoee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmplyoeePage");
		mv.addObject("emplyoee", new Emplyoee());
		mv.addObject("genders", Gender.values());
		mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		return mv;
	}

	@PostMapping("/addEmplyoee")
	public ModelAndView handleAddEmplyoee(@ModelAttribute("emplyoee") @Valid Emplyoee emplyoee,
			BindingResult validationResults) {
		ModelAndView mv = new ModelAndView();
		boolean flag = false;
		Emplyoee c = emplyoeeService.getEmplyoeeById(emplyoee.getEmpId());
		if (c != null) {
			if (!emplyoee.getEmailId().equals(c.getEmailId())) {
				if (emplyoeeService.existsByEmailId(emplyoee.getEmailId())) {
					validationResults.rejectValue("emailId", "error.emplyoee", "Email Id Already Exists");
				}
			}
			if (!emplyoee.getMobileNumber().equals(c.getMobileNumber())) {
				if (emplyoeeService.existsByMobileNumber(emplyoee.getMobileNumber())) {
					validationResults.rejectValue("mobileNumber", "error.emplyoee", "Mobile Number Already Exists");
				}
			}
			flag = true;
		} 
		else {
			if (emplyoeeService.existsByEmailId(emplyoee.getEmailId())) {
				validationResults.rejectValue("emailId", "error.emplyoee", "Email Id Already Exists");
			}
			if (emplyoeeService.existsByMobileNumber(emplyoee.getMobileNumber())) {
				validationResults.rejectValue("mobileNumber", "error.emplyoee", "Mobile Number Already Exists");
			}

		}
		if (validationResults.hasErrors()) {
			mv.setViewName("addEmplyoeePage");
			mv.addObject("emplyoee", emplyoee);
			mv.addObject("genders", Gender.values());
			mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		}
		// System.out.println(emplyoee.getEmpId());
		if (!flag)
			emplyoeeService.addEmplyoee(emplyoee);
		else
			emplyoeeService.updateEmplyoee(emplyoee);
		mv.setViewName("redirect:/emplyoeeList");
		return mv;
	}

	@GetMapping("/editEmp")
	public ModelAndView editBookAction(@RequestParam("empId") int empId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmplyoeePage");
		mv.addObject("emplyoee", emplyoeeService.getEmplyoeeById(empId));
		mv.addObject("genders", Gender.values());
		mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		return mv;
	}

	@GetMapping("/deleteEmp")
	public String deleteEmpAction(@RequestParam("empId") int empId) {
		emplyoeeService.deleteEmplyoee(empId);
		return "redirect:/emplyoeeList";
	}

	@GetMapping("/searchEmplyoee")
	public String handleSearchEmplyoee() {
		return "searchPage";
	}

	@PostMapping("/searchEmplyoee")
	public ModelAndView handleDoSearchEmplyoee(@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchPage");
		mv.addObject("pageTitle", "Results for " + byField + "= " + searchValue);
		switch (byField) {
		case "mobile":
			mv.addObject("result", emplyoeeService.findByMobileNumber(searchValue));
			break;
		case "email":
			mv.addObject("result", emplyoeeService.findByEmailId(searchValue));
			break;
		case "lnm":
			mv.addObject("results", emplyoeeService.findAllByLastName(searchValue));
			break;
		case "dp":
			mv.addObject("results", emplyoeeService.findAllByDept(searchValue));
			break;
		case "dob":
			mv.addObject("results", emplyoeeService.findAllByDateOfBirth(LocalDate.parse(searchValue)));
			break;
		}
		return mv;
	}

}
