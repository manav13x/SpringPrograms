package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.isa.ContractEmployee;
import com.verizon.jhd.model.isa.Employee;
import com.verizon.jhd.model.isa.Manager;
import com.verizon.jhd.util.JPAUtil;

public class IsADemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1=new Employee(101,"Priya",75643);
		ContractEmployee emp2=new ContractEmployee(102,"Amulya",6543,45);
		Manager emp3=new Manager(103,"Jo",78545,5698);

		EntityManager em=
				JPAUtil.getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		txn.commit();
		JPAUtil.shutdown();
		
	}

}
