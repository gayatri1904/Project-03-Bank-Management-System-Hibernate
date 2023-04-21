package com.jsp.controller.customer;

import com.jsp.dto.BankManager;
import com.jsp.dto.Customer;
import com.jsp.service.BankManagerService;
import com.jsp.service.CustomerService;

public class SaveCustomer {

	public static void main(String[] args) {

		BankManagerService bankManagerService = new BankManagerService();
		BankManager bankManager = bankManagerService.getByIdBankManager(4);

		Customer customer = new Customer();
		customer.setName("jay");
		customer.setStatus("Approved");
		customer.setBankManager(bankManager);

		CustomerService customerService = new CustomerService();
		customerService.saveCustomer(customer);

	}

}
