package com.verizon.emp.dao;

import java.sql.Types;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Emplyoee;
@Repository
public class EmpDAOJdbcTemplateImpl implements EmplyoeeDao {

	private SqlUpdate insOperator;
	private SqlUpdate updOperator;
	private SqlUpdate delOperator;
	private MappingSqlQuery<Emplyoee> getEmpOperator;
	private MappingSqlQuery<Emplyoee> getAllEmpsOperator;
	@Autowired
	public EmpDAOJdbcTemplateImpl(DataSource ds) {
		// TODO Auto-generated constructor stub
		this.insOperator = new SqlUpdate(ds,IQueryMapper.INS_EMP_QRY);
		this.updOperator = new SqlUpdate(ds,IQueryMapper.UPDATE_EMP_QRY);
		this.delOperator = new SqlUpdate(ds,IQueryMapper.DEL_EMP_QRY);
		
		SqlParameter param1 = new SqlParameter("empid",Types.INTEGER);
		SqlParameter param2 = new SqlParameter("ename",Types.VARCHAR);
		SqlParameter param3 = new SqlParameter("basic",Types.DECIMAL);
		SqlParameter param4 = new SqlParameter("hra",Types.DECIMAL);
		SqlParameter param5 = new SqlParameter("dept",Types.VARCHAR);
		
		
		insOperator.declareParameter(param1);
		insOperator.declareParameter(param2);
		insOperator.declareParameter(param3);
		insOperator.declareParameter(param4);
		insOperator.declareParameter(param5);
		insOperator.compile();
		
		updOperator.declareParameter(param2);
		updOperator.declareParameter(param3);
		updOperator.declareParameter(param4);
		updOperator.declareParameter(param5);
		updOperator.declareParameter(param1);
		updOperator.compile();
		
		delOperator.declareParameter(param1);
		delOperator.compile();
		
		this.getEmpOperator = new EmpQuery(ds,IQueryMapper.GET_EMP_QRY); 		
		this.getEmpOperator.declareParameter(param1);
		this.getEmpOperator.compile();
		
		this.getAllEmpsOperator = new EmpQuery(ds,IQueryMapper.GET_ALL__EMP_QRY);
		getAllEmpsOperator.compile();
	}
	@Override
	public Emplyoee addEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
	this.insOperator.update(Emplyoee.getEmpid(),Emplyoee.getEname(),Emplyoee.getBasic(),Emplyoee.getHra(),Emplyoee.getDept());
	return Emplyoee;
	}

	@Override
	public Emplyoee updateEmplyoee(Emplyoee Emplyoee) {
		// TODO Auto-generated method stub
		this.updOperator.update(Emplyoee.getEname(),Emplyoee.getBasic(),Emplyoee.getHra(),Emplyoee.getDept(),Emplyoee.getEmpid());
	return Emplyoee;
	}

	@Override
	public Emplyoee getEmplyoeeById(int empid) {
		// TODO Auto-generated method stub
		Emplyoee Emplyoee = null;
		List<Emplyoee> Emplyoees = this.getEmpOperator.execute(empid);
		
		if(Emplyoees!=null && Emplyoees.size()==1){
			Emplyoee=Emplyoees.get(0);
		}
		return Emplyoee;
	}

	@Override
	public boolean deleteEmplyoeeById(int empid) {
		// TODO Auto-generated method stub
	boolean isDeleted =  false;
	int count  = this.delOperator.update(empid);
	if(count>=1){
		isDeleted = true;
	}
		return isDeleted;
	}

	@Override
	public List<Emplyoee> getAllEmplyoees() {
		// TODO Auto-generated method stub
		List<Emplyoee> Emplyoees = this.getAllEmpsOperator.execute();
		
		return Emplyoees;
	}

}
