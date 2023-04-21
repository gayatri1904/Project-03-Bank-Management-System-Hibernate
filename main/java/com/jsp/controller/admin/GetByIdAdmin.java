package com.jsp.controller.admin;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

public class GetByIdAdmin {

	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		Admin admin = adminService.getByIdAdmin(1);

		System.out.println("Admins Id: " + admin.getId());
		System.out.println("Admins Name: " + admin.getName());
		System.out.println("Admins Email: " + admin.getEmail());
		System.out.println("Admins Password: " + admin.getPassword());

	}

}
