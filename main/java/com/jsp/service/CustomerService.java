package com.jsp.service;

import java.util.List;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();

	public Customer saveCustomer(Customer customer) {
		if (customer != null) {
			customer.setStatus("Unapproved");
		}
		return customerDao.saveCustomer(customer);
	}

	public Customer getByByIdCustomer(int id) {
		return customerDao.getByIdCustomer(id);
	}

	public Customer deleteCustomer(int id) {
		Customer customer = customerDao.getByIdCustomer(id);
		return customerDao.deleteCustomer(customer);
	}

	public Customer updateCustomer(Customer customer, int id) {
		Customer customer2 = customerDao.getByIdCustomer(id);
		if (customer.getName() != null) {
			customer2.setName(customer.getName());
		}
		if (customer.getStatus() != null) {
			customer2.setStatus(customer.getStatus());
		}
		if (customer2 != null) {
			customer2.setStatus("Unapproved");
			return customerDao.updateCustomer(customer2);
		}
		return null;

	}

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

}
