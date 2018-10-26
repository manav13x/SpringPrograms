package com.verizon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@GetMapping
	public ModelAndView defaultBookAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("bookFormPage");
		mv.addObject("book2", new Book());
		mv.addObject("posibCategories", new String[] { "TextBook", "Novel", "Magazine", "Transcripts" });
		mv.addObject("posibTypes", new String[] { "Hand-Written", "Printed", "Digital" });

		return mv;
	}

	@PostMapping
	public ModelAndView saveBookAction(@ModelAttribute("book2") Book book) {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("bookViewPage");
		mv.addObject("book", book);
		
		return mv;
	}
}
