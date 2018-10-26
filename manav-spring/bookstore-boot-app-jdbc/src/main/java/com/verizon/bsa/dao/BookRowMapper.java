package com.verizon.bsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.verizon.bsa.model.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBcode(rs.getInt(1));//get data from colmun 1
		book.setTitle(rs.getString(2));
		book.setPrice(rs.getDouble(3));
		book.setCategory(rs.getString(4));
		book.setType(rs.getString(5));
		return book;
	}

}
