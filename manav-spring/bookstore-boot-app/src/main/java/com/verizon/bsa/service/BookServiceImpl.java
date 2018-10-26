package com.verizon.bsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.BookDao;
import com.verizon.bsa.model.Book;
@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDao bookDao;
	//here  third parameter condition  and unless  is given
	@CachePut(value="books",key="#book.bcode")//book parameter to access
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}
	@CachePut(value="books",key="#book.bcode")
	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}
	@Cacheable(value="books",key="#bcode")//key should match with function parameter
	@Override
	public Book getBookById(int bcode) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(bcode);
	}
	@CacheEvict(value="books",key="#bcode")
	@Override
	public boolean deleteBookById(int bcode) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookById(bcode);
	}
	@Cacheable(value="books")
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		System.out.println("All Books");
		return bookDao.getAllBooks();
	}

}
