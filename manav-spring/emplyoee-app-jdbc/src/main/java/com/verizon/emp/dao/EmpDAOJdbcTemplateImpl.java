package com.verizon.emp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Emplyoee;
@Repository
public class EmpDAOJdbcTemplateImpl implements EmplyoeeDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmpDAOJdbcTemplateImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Emplyoee addEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
	int count =	jdbcTemplate.update(IQueryMapper.INS_EMP_QRY,
				Emplyoee.getEmpid(),
				Emplyoee.getEname(),
				Emplyoee.getBasic(),
				Emplyoee.getHra(),
				Emplyoee.getDept()
				);
	if(count < 1)
		Emplyoee = null;
	return Emplyoee;
	}

	@Override
	public Emplyoee updateEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
		int count =	jdbcTemplate.update(IQueryMapper.UPDATE_EMP_QRY,
				Emplyoee.getEname(),
				Emplyoee.getBasic(),
				Emplyoee.getHra(),
				Emplyoee.getDept(),
				Emplyoee.getEmpid()
				);
	if(count < 1)
		Emplyoee = null;
	return Emplyoee;
	}

	@Override
	public Emplyoee getEmplyoeeById(int empid) {
		// TODO Auto-generated method stub
		List<Emplyoee> Emplyoees = jdbcTemplate.query(IQueryMapper.GET_EMP_QRY,
				new Object[] {empid},
				new  EmpRowMapper());
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
	int count  = jdbcTemplate.update(
			IQueryMapper.DEL_EMP_QRY,empid);
	if(count>=1){
		isDeleted = true;
	}
		return isDeleted;
	}

	@Override
	public List<Emplyoee> getAllEmplyoees() {
		// TODO Auto-generated method stub
		List<Emplyoee> Emplyoees = jdbcTemplate.query(IQueryMapper.GET_ALL__EMP_QRY,
				new  EmpRowMapper());
		
		return Emplyoees;
	}

}
