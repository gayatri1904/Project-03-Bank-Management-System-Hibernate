package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gayatri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Admin saveAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;

	}

	public Admin getByIdAdmin(int id) {
		return entityManager.find(Admin.class, id);
	}

	public Admin deleteAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		return admin;

	}

	public Admin updateAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

	public List<Admin> getAllAdmin() {
		String sql = "select s from Admin s";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		return admins;

	}

}
