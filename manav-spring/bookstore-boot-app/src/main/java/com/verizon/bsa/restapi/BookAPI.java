package com.verizon.bsa.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.verizon.bsa.model.Book;
import com.verizon.bsa.service.BookService;
import com.verizon.bsa.service.BookServiceImpl;



@RestController
@RequestMapping("/books")
public class BookAPI {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> listBooksAction(){
		return new ResponseEntity<List<Book>>
				(bookService.getAllBooks(),HttpStatus.OK);
	}
	@GetMapping("/{bcode}")
	public ResponseEntity<Book> getBookAction(@PathVariable("bcode")int bcode){
		ResponseEntity<Book> resp=null;
		Book b = bookService.getBookById(bcode);
		if(b==null)
				resp =  new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<Book>(b,HttpStatus.OK);
		return resp;
	}
	@DeleteMapping("/{bcode}")
	public ResponseEntity<Void> deleteBookAction(@PathVariable("bcode")int bcode){
		ResponseEntity<Void> resp=null;
		boolean isDeleted = bookService.deleteBookById(bcode);
		if(!isDeleted)
				resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}
	@PostMapping
	public ResponseEntity<Book> addBookAction(@RequestBody Book book){
		ResponseEntity<Book> resp = null;
		book = bookService.addBook(book);
		if(book!=null)
			resp = new ResponseEntity<>(book,HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return resp;
	}
	@PutMapping
	public ResponseEntity<Book> updateBookAction(@RequestBody Book book){
		ResponseEntity<Book> resp = null;
		if(bookService.getBookById(book.getBcode())==null){
			resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			book = bookService.updateBook(book);
			if(book!=null)
					resp = new ResponseEntity<>(book,HttpStatus.OK);
			else
				resp = new ResponseEntity<>(book,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
