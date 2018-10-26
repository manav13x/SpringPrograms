package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Book;
import com.verizon.jhd.util.JPAUtil;

public class SaveBookApp {
	public static void main(String[] args) {
		
		Book b1 = new Book(101, "Book Title 1", 255);
		Book b2 = new Book(102, "Book Title 2", 55);
		Book b3 = new Book(103, "Book Title 3", 155);
		
		EntityManager em = JPAUtil.getEntityManagerFactory()
						.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		txn.commit();
		
		System.out.println("Data Persisted");
		
		JPAUtil.shutdown();
	}

}
