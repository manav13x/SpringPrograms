package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.util.JPAUtil;

public class SavePersonApp {
	public static void main(String args[])

	{
			Person p = new Person("Srinu","Jha",Gender.Masculine,true,LocalDate.of(1995,06,11));		
		
			EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();		
			EntityTransaction txn = em.getTransaction();		
			
			txn.begin();		
			em.persist(p);		
			txn.commit();	
			
			JPAUtil.shutdown();
	}

}
