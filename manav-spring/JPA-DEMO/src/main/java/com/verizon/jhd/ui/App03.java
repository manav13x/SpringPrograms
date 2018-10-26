package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.model.composition.Address;
import com.verizon.jhd.model.composition.Emplyoee;
import com.verizon.jhd.util.JPAUtil;

public class App03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emplyoee p = new Emplyoee("Srinu",Gender.Masculine,LocalDate.of(1995,06,11),new Address());
		
		EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
				EntityTransaction txn = em.getTransaction();
				txn.begin();
				em.persist(p);
				txn.commit();
				}
	}
