package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.OnetoOne.LibMembership;
import com.verizon.jhd.model.OnetoOne.Student;
import com.verizon.jhd.util.JPAUtil;

public class OneToOneLib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student emp=new Student(101,"Amulya","CSE");
		LibMembership acc=new LibMembership("L0001",3);
		emp.setLibAccount(acc);
		acc.setAccHolder(emp);
		
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(emp);
		txn.commit();
		JPAUtil.shutdown();
	
	}

}
