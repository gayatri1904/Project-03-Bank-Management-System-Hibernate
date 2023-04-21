package com.jsp.controller.customer;

import java.util.List;

import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

public class GetAllCustomers {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAllCustomer();

		for (Customer customer : customers) {
			System.out.println("==================================================");
			System.out.println("Customer ID     : " + customer.getId());
			System.out.println("Customer Name   : " + customer.getName());
			System.out.println("Customer Status : " + customer.getStatus());

		}

	}

}
