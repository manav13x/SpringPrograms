package com.verizon.emp.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@GetMapping({"","/","/home"})
	public ModelAndView handlerootRequest(){
		
		ModelAndView mv =  new ModelAndView("index");
		return mv;
	}
}
