package com.jsp.controller.admin;

import java.util.List;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

public class GetAllAdmin {

	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		List<Admin> admins = adminService.getAllAdmin();
		for (Admin admin : admins) {
			System.out.println("======================================================");
			System.out.println("Admin ID        : " + admin.getId());
			System.out.println("Admin Name      : " + admin.getName());
			System.out.println("Admin Email     : " + admin.getEmail());
			System.out.println("Admin Passoword : " + admin.getPassword());

		}

	}

}
