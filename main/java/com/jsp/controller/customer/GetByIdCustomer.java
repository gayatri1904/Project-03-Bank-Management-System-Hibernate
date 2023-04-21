package com.jsp.controller.customer;

import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

public class GetByIdCustomer {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getByByIdCustomer(4);
		System.out.println("Customers id: " + customer.getId());
		System.out.println("Customers Name: " + customer.getName());
		System.out.println("Customers status: " + customer.getStatus());

	}

}
