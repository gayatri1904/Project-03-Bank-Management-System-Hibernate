package com.jsp.controller.admin;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

public class UpdateAdmin {

	public static void main(String[] args) {

		Admin admin = new Admin();
		admin.setName("Bhavna");
		admin.setEmail("bhavna@gmail.com");
		admin.setPassword("bhavna76");

		AdminService adminService = new AdminService();
		adminService.updateAdmin(admin, 2);

	}

}
