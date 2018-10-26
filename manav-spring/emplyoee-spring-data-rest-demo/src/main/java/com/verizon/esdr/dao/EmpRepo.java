package com.verizon.esdr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.esdr.model.Emplyoee;
@Repository
public interface EmpRepo extends JpaRepository<Emplyoee, Long>{

}
