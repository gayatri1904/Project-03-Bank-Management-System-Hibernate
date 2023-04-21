package com.jsp.controller.bankmanager;

import com.jsp.service.BankManagerService;

public class ApproveCustomer {

	public static void main(String[] args) {

		BankManagerService bankManagerService = new BankManagerService();
		bankManagerService.approveCustomerById(2, 6);

	}

}
