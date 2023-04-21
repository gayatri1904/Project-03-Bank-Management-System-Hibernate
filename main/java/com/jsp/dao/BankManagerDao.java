package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankManager;

public class BankManagerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gayatri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public BankManager saveBankManager(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		return bankManager;

	}

	public BankManager getByIdBankManager(int id) {
		return entityManager.find(BankManager.class, id);
	}

	public BankManager deleteBankManager(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.remove(bankManager);
		entityTransaction.commit();
		return bankManager;

	}

	public BankManager updateBankManager(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		return bankManager;
	}

	public List<BankManager> getAllBankManagers() {
		String sql = "select s from BankManager s";
		Query query = entityManager.createQuery(sql);
		List<BankManager> bankManagers = query.getResultList();
		
		return bankManagers;
	}

}
