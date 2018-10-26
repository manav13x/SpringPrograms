package com.verizon.emp.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Emplyoee;
@Repository
public class EmpDAOJdbcTemplateImpl implements EmplyoeeDao {

	private NamedParameterJdbcTemplate jtmp;
	@Autowired
	private EmpRowMapper rowMapper;
	@Autowired
	public EmpDAOJdbcTemplateImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.jtmp = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public Emplyoee addEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
	int count =	jtmp.update(IQueryMapper.INS_EMP_QRY,
			new BeanPropertySqlParameterSource(Emplyoee));
	if(count < 1)
		Emplyoee = null;
	return Emplyoee;
	}

	@Override
	public Emplyoee updateEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
		int count =	jtmp.update(IQueryMapper.UPDATE_EMP_QRY,
				new BeanPropertySqlParameterSource(Emplyoee)
				);
	if(count < 1)
		Emplyoee = null;
	return Emplyoee;
	}

	@Override
	public Emplyoee getEmplyoeeById(int empid) {
		// TODO Auto-generated method stub
		List<Emplyoee> Emplyoees = jtmp.query(IQueryMapper.GET_EMP_QRY,
				Collections.singletonMap("empid", empid),
				rowMapper);
		Emplyoee Emplyoee = null;
		if(Emplyoees!=null && Emplyoees.size()==1){
			Emplyoee=Emplyoees.get(0);
		}
		return Emplyoee;
	}

	@Override
	public boolean deleteEmplyoeeById(int empid) {
		// TODO Auto-generated method stub
	boolean isDeleted =  false;
	int count  = jtmp.update(
			IQueryMapper.DEL_EMP_QRY,Collections.singletonMap("empid", empid));
	if(count>=1){
		isDeleted = true;
	}
		return isDeleted;
	}

	@Override
	public List<Emplyoee> getAllEmplyoees() {
		// TODO Auto-generated method stub
		List<Emplyoee> Emplyoees = jtmp.query(IQueryMapper.GET_ALL__EMP_QRY,
				rowMapper);
		
		return Emplyoees;
	}

}
