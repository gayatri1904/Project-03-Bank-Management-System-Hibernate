package com.jsp.controller.account;

import com.jsp.service.AccountService;

public class TransferMoney {

	public static void main(String[] args) {

		AccountService accountService = new AccountService();
		accountService.transferMoney(6, 6, 5, 10000);
	}
}
