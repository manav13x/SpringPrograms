package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.Service.SimpleInterest;
import com.verizon.model.Interest;

@Controller
@RequestMapping("/interest")
public class SIController {
	
	@Autowired
	private SimpleInterest interestserv;
	
	@GetMapping
	public String defaultInterestAction() {
		return "interestForm";
	}

	
	//if the request is POST
	@PostMapping
	public ModelAndView submitInterestAction(
	/*		@RequestParam("pri")double principal,
			@RequestParam("rate")double rate,
			@RequestParam("time")double time*/
			@ModelAttribute Interest interest) {
		
	ModelAndView mv=new ModelAndView();
	
	mv.setViewName("interestShowPage");
	interest.setSimpleInterest(interestserv.showInterest(interest));
	interest.setRepayableAmount(interestserv.getPayableAmount(interest));
	mv.addObject("interest",interest);		
	
	return mv;
	}

}
