package com.jsp.controller.bankmanager;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

public class UpdateBankManager {

	public static void main(String[] args) {
		BankManager bankManager = new BankManager();
		bankManager.setName("xyzw");
		bankManager.setEmail("xyz@gmail.com");
		bankManager.setPassword("xyz89");
		bankManager.setStatus("Approved");

		BankManagerService bankManagerService = new BankManagerService();
		bankManagerService.updateBankManager(bankManager, 3);
	}

}
