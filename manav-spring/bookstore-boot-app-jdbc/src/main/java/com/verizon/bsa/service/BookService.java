package com.verizon.bsa.service;

import java.util.List;

import com.verizon.bsa.model.Book;

public interface BookService {

	Book addBook(Book book);
	Book updateBook(Book book);
	Book getBookById(int bcode);
	boolean deleteBookById(int bcode);
	List<Book> getAllBooks();
}
