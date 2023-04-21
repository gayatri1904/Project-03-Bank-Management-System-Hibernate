package com.jsp.controller.account;

import com.jsp.dto.Account;
import com.jsp.service.AccountService;

public class GetByIdAccount {

	public static void main(String[] args) {

		AccountService accountService = new AccountService();
		Account account = accountService.getByIdAccount(2);

		System.out.println("Account Id       : " + account.getId());
		System.out.println("Account Name     : " + account.getName());
		System.out.println("Account Acc_no   : " + account.getAcc_no());
		System.out.println("Account IFSC_code: " + account.getIfsc_code());
		System.out.println("Account Balance  : " + account.getBalance());

	}

}
