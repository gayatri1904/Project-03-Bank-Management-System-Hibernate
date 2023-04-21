package com.jsp.controller.admin;

import com.jsp.service.AdminService;

public class ApproveBankManager {

	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		adminService.approveBankManagerById(1, 2);

	}

}
