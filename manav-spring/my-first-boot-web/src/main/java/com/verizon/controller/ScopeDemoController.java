package com.verizon.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeDemoController {
	
	private int counter;	//default value 0
	
	@GetMapping("/scopedemo")
	public ModelAndView defaultAction() {
		counter++;
		return new ModelAndView("sdpage","count",counter);
	}
}
