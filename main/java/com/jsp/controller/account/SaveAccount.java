package com.jsp.controller.account;

import com.jsp.dto.Account;
import com.jsp.dto.Customer;
import com.jsp.service.AccountService;
import com.jsp.service.CustomerService;

public class SaveAccount {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		Customer customer =customerService.getByByIdCustomer(9);
		
		Account account=new Account();
		account.setName("savings account");
		account.setAcc_no("13563278");
		account.setIfsc_code("Axis689");
		account.setBalance(20000);
		account.setCustomer(customer);
		
		AccountService accountService=new AccountService();
		Account account2 =accountService.saveAccount(account);
		if(account2 != null) {
			System.out.println("Account has been created");
		}
		
	}

}
