package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.BankManagerDao;
import com.jsp.dao.CustomerDao;
import com.jsp.dto.BankManager;
import com.jsp.dto.Customer;

public class BankManagerService {

	BankManagerDao bankManagerDao = new BankManagerDao();
	CustomerService customerService = new CustomerService();
	CustomerDao customerDao = new CustomerDao();

	public BankManager saveBankManager(BankManager bankManager) {
		if (bankManager != null) {
			bankManager.setStatus("unapproved");
		}
		return bankManagerDao.saveBankManager(bankManager);
	}

	public BankManager getByIdBankManager(int id) {
		return bankManagerDao.getByIdBankManager(id);
	}

	public BankManager deleteBankManager(int id) {
		BankManager bankManager = bankManagerDao.getByIdBankManager(id);
		return bankManagerDao.deleteBankManager(bankManager);

	}

	public BankManager updateBankManager(BankManager bankManager, int id) {
		BankManager bankManager2 = bankManagerDao.getByIdBankManager(id);
		if (bankManager.getName() != null) {
			bankManager2.setName(bankManager.getName());
		}
		if (bankManager.getEmail() != null) {
			bankManager2.setEmail(bankManager.getEmail());
		}
		if (bankManager.getPassword() != null) {
			bankManager2.setPassword(bankManager.getPassword());
		}
		if (bankManager.getStatus() != null) {
			bankManager2.setStatus(bankManager.getStatus());
		}
		if (bankManager2 != null) {
			bankManager2.setStatus("Unapproved");
			return bankManagerDao.updateBankManager(bankManager2);
		}
		return null;

	}

	public List<BankManager> getAllBankManagers() {
		return bankManagerDao.getAllBankManagers();

	}

	public List<Customer> viewAllUnapprovedCustomers() {
		CustomerService customerService = new CustomerService();

		List<Customer> customers = customerService.getAllCustomer();
		List<Customer> customers2 = new ArrayList<Customer>();

		for (Customer customer : customers) {
			if (customer.getStatus().equalsIgnoreCase("Unapproved"))
				customers2.add(customer);
		}
		return customers2;
	}

	public List<Customer> viewAllApprovedCustomers() {
		CustomerService customerService = new CustomerService();

		List<Customer> customers = customerService.getAllCustomer();
		List<Customer> customers2 = new ArrayList<Customer>();

		for (Customer customer : customers) {
			if (customer.getStatus().equalsIgnoreCase("Approved"))
				customers2.add(customer);
		}
		return customers2;
	}

	public void approveCustomerById(int bm_id, int customer_id) {
		BankManager bankManager = bankManagerDao.getByIdBankManager(bm_id);
		Customer customer = customerService.getByByIdCustomer(customer_id);

		if (bankManager.getStatus().equalsIgnoreCase("Approved")) {
			if (bankManager.getId() == customer.getBankManager().getId()) {
				customer.setStatus("Approved");
			} else
				System.out.println("Record Doesn't Matches");

		} else
			System.out.println("Get Approved First");
		customerDao.updateCustomer(customer);
	}

}
