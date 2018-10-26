package com.verizon.jhd.ui;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.composition.HallTicket;
import com.verizon.jhd.model.composition.Identification;
import com.verizon.jhd.util.JPAUtil;

public class GenerateHallTck {
	
	public static void main(String args[]) {
		HallTicket emp2=new HallTicket("102","Priya","SSC",new Identification());
	
		EntityManager em=
				JPAUtil.getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		//em.persist(emp1);
		em.persist(emp2);
		txn.commit();
		JPAUtil.shutdown();

	}

	}
