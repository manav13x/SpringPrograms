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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()){
			mv.addObject("currentUserName",auth.getName());
		} 
		
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginPage(){
		return new ModelAndView("loginPage");
	}
	@GetMapping("/error")
	public String errorPage(){
			return "Invalid Credentials For this operation";
	}
}
