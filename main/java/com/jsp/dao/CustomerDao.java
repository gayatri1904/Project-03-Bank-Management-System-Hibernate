package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gayatri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Customer saveCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}

	public Customer getByIdCustomer(int id) {
		return entityManager.find(Customer.class, id);
	}

	public Customer deleteCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		return customer;

	}

	public Customer updateCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return customer;

	}

	public List<Customer> getAllCustomer() {
		String sql = "select s from Customer s";
		Query query = entityManager.createQuery(sql);
		List<Customer> customers = query.getResultList();

		return customers;
	}

}
