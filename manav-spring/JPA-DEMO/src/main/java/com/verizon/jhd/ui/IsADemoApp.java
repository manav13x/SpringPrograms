package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.composition.Emplyoee;
import com.verizon.jhd.model.isa.ContractEmployee;
import com.verizon.jhd.model.isa.Emp;
import com.verizon.jhd.model.isa.Manager;
import com.verizon.jhd.util.JPAUtil;

public class IsADemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Emp emp1 = new Emp(101,"RAM",75855);
		ContractEmployee emp2 = new ContractEmployee(102,"SOMU",2345,45);
		Manager emp3 = new Manager(103,"SHYAM",78545,5689);
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txt = em.getTransaction();
		txt.begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		txt.commit();
		JPAUtil.shutdown();
	}

}
