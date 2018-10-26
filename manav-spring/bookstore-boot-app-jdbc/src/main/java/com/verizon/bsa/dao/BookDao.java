package com.verizon.bsa.dao;

import java.util.List;

import com.verizon.bsa.model.Book;

public interface BookDao {

	Book addBook(Book book);
	Book updateBook(Book book);
	Book getBookById(int bcode);
	boolean deleteBookById(int bcode);
	List<Book> getAllBooks();
}
