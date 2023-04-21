package com.jsp.controller.admin;

import java.util.List;

import com.jsp.dto.BankManager;
import com.jsp.service.AdminService;

public class ViewAllUnapprovedBankManagers {

	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		List<BankManager> bankManagers = adminService.viewAllUnapprovedBankManagers();
		for (BankManager bankManager : bankManagers) {
			System.out.println("BankManager's id       : " + bankManager.getId());
			System.out.println("BankManager's Name     : " + bankManager.getName());
			System.out.println("BankManager's Email    : " + bankManager.getEmail());
			System.out.println("BankManager's Password : " + bankManager.getPassword());
			System.out.println("BankManager's status   : " + bankManager.getStatus());
			System.out.println("==========================================================");
		}

	}

}
