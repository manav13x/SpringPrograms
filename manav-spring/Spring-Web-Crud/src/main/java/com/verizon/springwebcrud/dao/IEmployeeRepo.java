package com.verizon.springwebcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springwebcrud.model.Employee;
@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long>{

}
