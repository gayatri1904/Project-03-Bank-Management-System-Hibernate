package com.jsp.controller.customer;

import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

public class UpdateCustomer {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setName("wtf");
		customer.setStatus("Approved");

		CustomerService customerServic = new CustomerService();
		Customer customer2 = customerServic.updateCustomer(customer, 1);
		if (customer2 != null)
			System.out.println("Customer Record updated");
	}

}
