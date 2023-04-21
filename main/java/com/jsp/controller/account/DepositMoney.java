package com.jsp.controller.account;

import com.jsp.service.AccountService;

public class DepositMoney {

	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		accountService.depositMoney(6, 6, 123456);
	}
}
