package com.verizon.jhd.ui;

import javax.persistence.EntityManager;

import com.verizon.jhd.model.OnetoOne.BankAccount;
import com.verizon.jhd.model.OnetoOne.Emp;
import com.verizon.jhd.util.JPAUtil;

public class OneToOneRetrivalDemo {
	public static void main(String args[]) {
	
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		Emp emp=em.find(Emp.class,101);
		//em.close();
		//JPAUtil.shutdown();
		
		if(emp!=null) {
			System.out.println("Emp Name:" + emp.getEname());
			BankAccount acc=emp.getSalaryAccount();
			System.out.println("Bank acc Number:" + acc.getAccNum());		
			
		}
	
	
	
	}

}
