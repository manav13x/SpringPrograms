package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.association.BankAccount;
import com.verizon.jhd.model.association.Citizen;
import com.verizon.jhd.model.association.GasSubscription;
import com.verizon.jhd.util.JPAUtil;

public class App04 {
	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		acc.setAccNumber("SB001");
		acc.setBal(23000);
		GasSubscription gasSub = new GasSubscription();
		gasSub.setDateOfSubscription(LocalDate.now());
		Citizen c = new Citizen();
		c.setAadharId("999999999999");
		c.setBankAccount(acc);
		c.setGasSubscription(gasSub);
		c.setName("Srinu");
		acc.setAccountHolder(c);
		gasSub.setSubscriber(c);
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(c);
		txn.commit();
		JPAUtil.shutdown();
	}
}