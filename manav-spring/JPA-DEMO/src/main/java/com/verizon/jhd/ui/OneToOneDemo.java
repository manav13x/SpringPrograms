package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.OnetoOne.BankAccount;
import com.verizon.jhd.model.OnetoOne.Emp;
import com.verizon.jhd.util.JPAUtil;

public class OneToOneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp emp=new Emp(101,"Amulya",56765.90);
		BankAccount acc=new BankAccount("SB0001","SBI","SB089");
		emp.setSalaryAccount(acc);
		acc.setAccHolder(emp);
		
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(emp);
		txn.commit();
		JPAUtil.shutdown();
	
	}

}
