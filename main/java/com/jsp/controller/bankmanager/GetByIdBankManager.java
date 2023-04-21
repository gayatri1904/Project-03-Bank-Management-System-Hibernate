package com.jsp.controller.bankmanager;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

public class GetByIdBankManager {

	public static void main(String[] args) {
		BankManagerService bankManagerService = new BankManagerService();
		BankManager bankManager = bankManagerService.getByIdBankManager(3);

		System.out.println("BankManager's Id: " + bankManager.getId());
		System.out.println("BankManager's Name: " + bankManager.getName());
		System.out.println("BankManager's Email: " + bankManager.getEmail());
		System.out.println("BankManager's Password: " + bankManager.getPassword());
		System.out.println("BankManager's Status: " + bankManager.getStatus());

	}

}
