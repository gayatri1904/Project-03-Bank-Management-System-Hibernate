package com.jsp.controller.bankmanager;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

public class DeleteBankManager {

	public static void main(String[] args) {

		BankManagerService bankManagerService = new BankManagerService();
		BankManager bankManager = bankManagerService.deleteBankManager(4);
		if (bankManager != null) {
			System.out.println("Bank Manager has been deleted");
		}

	}

}
