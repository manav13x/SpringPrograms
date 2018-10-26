package com.verizon.ssd.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
@Controller
public class CommonController {

	@GetMapping({"","/","/home"})
	public ModelAndView showHome(){
		
		ModelAndView mv =  new ModelAndView("home");
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
}
