package com.verizon.emp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import com.verizon.emp.model.Emplyoee;

public class EmpQuery extends MappingSqlQuery<Emplyoee> {

	 public EmpQuery() {
			// TODO Auto-generated constructor stub
			super();
		}
		public EmpQuery(DataSource ds,String sql){
			super(ds,sql);
		}
	@Override
	public Emplyoee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Emplyoee Emplyoee = new Emplyoee();
		Emplyoee.setEmpid(rs.getInt(1));//get data from colmun 1
		Emplyoee.setEname(rs.getString(2));
		Emplyoee.setBasic(rs.getDouble(3));
		Emplyoee.setHra(rs.getDouble(4));
		Emplyoee.setDept(rs.getString(5));
		return Emplyoee;
	}

}
