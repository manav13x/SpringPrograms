package com.verizon.emp.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;

@Component("customExceptionTranslator")
public class CustomExceptionTranslator implements SQLExceptionTranslator {
	
	@SuppressWarnings("serial")
	@Override
	public DataAccessException translate(String task, String sql, SQLException exception) {
		// TODO Auto-generated method stub
		return new DataAccessException(exception.toString()) {
		};
	}

	//converting SQL exception into data access exception
	
}
