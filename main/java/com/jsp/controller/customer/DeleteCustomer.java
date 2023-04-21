package com.jsp.controller.customer;

import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

public class DeleteCustomer {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		Customer customer = customerService.deleteCustomer(7);

		if (customer != null)
			System.out.println("Customer has been deleted");
	}

}
