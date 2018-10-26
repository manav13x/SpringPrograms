package com.verizon.jhp.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhp.model.isa.PersonalLoan;
import com.verizon.jhp.model.isa.PropertyLoan;
import com.verizon.jhp.model.isa.Loan;
import com.verizon.jhp.model.isa.GoldLoan;
import com.verizon.jhp.util.JPAUtil;

public class SaveLoan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Loan emp1=new Loan(101,10000,3);
		PersonalLoan emp2=new PersonalLoan(102,20000,6543,45);
		GoldLoan emp3=new GoldLoan(103,30000,78545,5698);
		PropertyLoan emp4=new PropertyLoan(104,30000,78545,5698);
		EntityManager em=
				JPAUtil.getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		//em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		txn.commit();
		JPAUtil.shutdown();

	}

}
