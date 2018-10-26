package com.verizon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.model.Book;

@RestController
public class DemoRestController {
	
	@GetMapping("/hello")
	public String helloAction() {
		return "Hello";
	}
	
	@GetMapping("/sampleBook")
	public Book sampleBookAction() {
		Book book=new Book();
		book.setBcode(999);
		book.setCategory("Manga");
		book.setTitle("Hero Academia");
		book.setType("Anime");
		book.setPrice(98989);
		return book;
	}
}
