package com.verizon.adb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.model.Contact;
import com.verizon.adb.model.Gender;
import com.verizon.adb.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contactList")
	public ModelAndView handleContactList(){
		return new ModelAndView("clistPage","contacts",contactService.getAllContacts());
	}
	@GetMapping("/addContact")
	public ModelAndView handleNewContact(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addContactPage");
		mv.addObject("contact",new Contact());
		mv.addObject("genders",Gender.values());
		return mv;
	}
	
	@PostMapping("/addContact")
	public ModelAndView handleAddContact(@ModelAttribute("contact") @Valid Contact contact,
			BindingResult validationResults){
		ModelAndView mv = new ModelAndView();
		
		if(contactService.existsByEmailId(contact.getEmailId())){
			//validationResults.addError(new ObjectError("emailId", "Email Id Already Exists"));
			validationResults.rejectValue("emailId", "error.contact", "Email Id Already Exists");
		}
		
		if(contactService.existsByMobileNumber(contact.getMobileNumber())){
			//validationResults.addError(new ObjectError("mobileNumber", "Mobile Number Already Exists"));
			validationResults.rejectValue("mobileNumber","error.contact","Mobile Number Already Exists");
		}
		
		
		if(validationResults.hasErrors()){
			mv.setViewName("addContactPage");
			mv.addObject("contact",contact);
			mv.addObject("genders",Gender.values());
		}
		else{
			contactService.addContact(contact);
			mv.setViewName("redirect:/contactList");
		}
		
		return mv;
	}
	@GetMapping("/searchContact")
	public String handleSearchContact(){
		return "searchPage";
	}
	@PostMapping("/searchContact")
	public ModelAndView handleDoSearchContact(
			@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField
			){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchPage");
		mv.addObject("pageTitle","Results for "+byField+"= "+searchValue);
		switch(byField){
		case "mobile":
					mv.addObject("result",contactService.findByMobileNumber(searchValue));
					break;
		case "email":
					mv.addObject("result",contactService.findByEmailId(searchValue));
					break;
		case "lnm":
				mv.addObject("results",contactService.findAllByLastName(searchValue));
				break;
		
		}
		return mv;
	}
}
