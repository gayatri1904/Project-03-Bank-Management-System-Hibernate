package com.jsp.controller.bankmanager;

import java.util.List;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

public class GetAllBankManager {

	public static void main(String[] args) {
		BankManagerService bankManagerService = new BankManagerService();
		List<BankManager> bankManagers = bankManagerService.getAllBankManagers();
		for (BankManager bankManager : bankManagers) {
			System.out.println("BankManager's id       : " + bankManager.getId());
			System.out.println("BankManager's Name     : " + bankManager.getName());
			System.out.println("BankManager's Email    : " + bankManager.getEmail());
			System.out.println("BankManager's Password : " + bankManager.getPassword());
			System.out.println("BankManager's status   : " + bankManager.getStatus());
			System.out.println("=============================================================");
		}

	}

}
