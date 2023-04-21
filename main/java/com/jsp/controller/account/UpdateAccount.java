package com.jsp.controller.account;

import com.jsp.dto.Account;
import com.jsp.service.AccountService;

public class UpdateAccount {

	public static void main(String[] args) {

		Account account = new Account();
		account.setAcc_no("afejwbf");
		account.setBalance(123);
		account.setIfsc_code("afefsaf");
		account.setName("efbwjfwef");

		AccountService accountService = new AccountService();
		Account account2 = accountService.updateAccount(account, 3);

		if (account2 != null)
			System.out.println("Account has been updated");
	}

}
