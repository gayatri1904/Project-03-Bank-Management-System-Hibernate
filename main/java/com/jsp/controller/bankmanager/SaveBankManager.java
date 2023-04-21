package com.jsp.controller.bankmanager;

import com.jsp.dto.Admin;
import com.jsp.dto.BankManager;
import com.jsp.service.AdminService;
import com.jsp.service.BankManagerService;

public class SaveBankManager {

	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		Admin admin = adminService.getByIdAdmin(2);

		BankManager bankManager = new BankManager();
		bankManager.setName("Prasad");
		bankManager.setEmail("Prasad@mail.com");
		bankManager.setPassword("pra4254");
		bankManager.setStatus("Unaprroved");
		bankManager.setAdmin(admin);

		BankManagerService bankManagerService = new BankManagerService();
		BankManager bankManager2 = bankManagerService.saveBankManager(bankManager);
		if (bankManager2 != null)
			System.out.println("Bank Manager Record Added");

	}
}
