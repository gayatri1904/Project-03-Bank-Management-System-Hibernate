package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Account;
import com.jsp.dto.Customer;
import com.jsp.service.AccountService;
import com.jsp.service.CustomerService;

public class AccountDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gayatri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	CustomerService customerService = new CustomerService();

	public Account saveAccount(Account account) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;

	}

	public Account getByIdAccount(int id) {
		return entityManager.find(Account.class, id);
	}

	public Account deleteAccount(Account account) {
		entityTransaction.begin();
		entityManager.remove(account);
		entityTransaction.commit();
		return account;

	}

	public Account updateAccount(Account account) {
        if (account != null) {
            entityTransaction.begin();
            entityManager.merge(account);
            entityTransaction.commit();
            return account;
        }
        return null;
	
	}

	public List<Account> getAllAccounts() {
		String sql = "select s from Account s";
		Query query = entityManager.createQuery(sql);
		List<Account> accounts = query.getResultList();
		return accounts;

	}

	public Account depositMoney(int customer_id, int account_no, double amount) {
        Customer customer = entityManager.find(Customer.class, customer_id);
        Account account = entityManager.find(Account.class, account_no);
        if (customer != null) {

            if (account != null) {

                if (customer.getStatus().equals("Approved")) {

                    if (account.getId() == customer.getId()) {
                        account.setBalance(account.getBalance() + amount);
                        updateAccount(account);
                    } else
                        System.out.println("ID Didn't Matched");

                } else
                    System.out.println("Customer is Not Approved");

            } else
                System.out.println("Account ID Doesn't Exists");

        } else
            System.out.println("Customer ID Doesnt Exists");

        return account;

    }

	public Account transferMoney(int customer_id, int sender, int reciever, double amount) {
		Customer customer = entityManager.find(Customer.class,customer_id);
		Account acc_sender = entityManager.find(Account.class, sender);
		Account acc_reci = entityManager.find(Account.class, reciever);

		if (customer.getStatus().equals("Approved") && sender== customer_id) {
			if (acc_sender != null && acc_reci != null) {
				if (acc_sender.getBalance() >= amount) {
					acc_sender.setBalance(acc_sender.getBalance() - amount);
					acc_reci.setBalance(acc_reci.getBalance() + amount);
					updateAccount(acc_sender);
					updateAccount(acc_reci);
				} else
					System.out.println("Cannot be more than Balance");
			} else
				System.out.println("Id Doesn't exits");
		}
		else System.out.println("Get Approved or Id doesn't matches");
		
		return acc_reci;

	}

}
