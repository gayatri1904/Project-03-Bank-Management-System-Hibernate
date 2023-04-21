package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dao.BankManagerDao;
import com.jsp.dto.Admin;
import com.jsp.dto.BankManager;

public class AdminService {

	AdminDao adminDao = new AdminDao();
	BankManagerService bankManagerService = new BankManagerService();
	BankManagerDao bankManagerDao = new BankManagerDao();

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public Admin getByIdAdmin(int id) {
		return adminDao.getByIdAdmin(id);
	}

	public Admin deleteAdmin(int id) {
		Admin admin = adminDao.getByIdAdmin(id);
		return adminDao.deleteAdmin(admin);
	}

	public Admin updateAdmin(Admin admin, int id) {
		Admin admin2 = adminDao.getByIdAdmin(id);
		if (admin.getName() != null) {
			admin2.setName(admin.getName());
		}
		if (admin.getEmail() != null) {
			admin2.setEmail(admin.getEmail());
		}
		if (admin.getPassword() != null) {
			admin2.setPassword(admin.getPassword());
		}
		return adminDao.updateAdmin(admin2);
	}

	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	public List<BankManager> viewAllUnapprovedBankManagers() {

		BankManagerService bankManagerService = new BankManagerService();
		List<BankManager> bankManagers = bankManagerService.getAllBankManagers();
		List<BankManager> bankManagers2 = new ArrayList<BankManager>();

		for (BankManager bankManager : bankManagers) {
			if (bankManager.getStatus().equalsIgnoreCase("Unapproved"))
				bankManagers2.add(bankManager);
		}
		return bankManagers2;
	}

	public List<BankManager> viewAllApprovedBankManagers() {

		BankManagerService bankManagerService = new BankManagerService();
		List<BankManager> bankManagers = bankManagerService.getAllBankManagers();
		List<BankManager> bankManagers2 = new ArrayList<BankManager>();

		for (BankManager bankManager : bankManagers) {
			if (bankManager.getStatus().equalsIgnoreCase("Approved"))
				bankManagers2.add(bankManager);
		}
		return bankManagers2;
	}

	public void approveBankManagerById(int admin_id, int bm_id) {

		Admin admin = adminDao.getByIdAdmin(admin_id);
		BankManager bankManager = bankManagerService.getByIdBankManager(bm_id);

		if (admin.getId() == bankManager.getAdmin().getId()) {
			bankManager.setStatus("Approved");
		} else
			System.out.println("Incorrect Details");

		bankManagerDao.updateBankManager(bankManager);

	}

}
