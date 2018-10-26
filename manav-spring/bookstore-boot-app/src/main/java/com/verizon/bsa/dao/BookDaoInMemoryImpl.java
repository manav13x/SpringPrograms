package com.verizon.bsa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.bsa.model.Book;
@Repository
public class BookDaoInMemoryImpl  implements BookDao{

	Map<Integer,Book> books;
	public BookDaoInMemoryImpl() {
		// TODO Auto-generated constructor stub
		books = new TreeMap<>();
		books.put(101, new Book(101,"Hound of Baskwrville",444,"Novel","Hardcopy"));
		books.put(102, new Book(102,"Hound of Baskwrville",444,"Novel","Hardcopy"));
		books.put(103, new Book(103,"Hound of Baskwrville",444,"Novel","Hardcopy"));
		
	}
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		books.put(book.getBcode(), book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		books.replace(book.getBcode(),book);
		return book;
	}

	@Override
	public Book getBookById(int bcode) {
		// TODO Auto-generated method stub
		return books.get(bcode);
	}

	@Override
	public boolean deleteBookById(int bcode) {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		if(books.containsKey(bcode))
		{
			books.remove(bcode);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>(books.values());
	}

}
