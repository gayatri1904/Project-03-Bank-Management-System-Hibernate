package com.jsp.service;

import java.util.List;

import com.jsp.dao.AccountDao;
import com.jsp.dto.Account;

public class AccountService {
	AccountDao accountDao = new AccountDao();

	public Account saveAccount(Account account) {
		if (account != null) {
			account.setBalance(0);
		}
		return accountDao.saveAccount(account);
	}

	public Account getByIdAccount(int id) {
		return accountDao.getByIdAccount(id);
	}

	public Account deleteAccount(int id) {
		Account account = accountDao.getByIdAccount(id);
		return accountDao.deleteAccount(account);
	}

	public Account updateAccount(Account account, int id) {
		Account account2 = accountDao.getByIdAccount(id);
		if (account.getName() != null) {
			account2.setName(account.getName());
		}
		if (account.getAcc_no() != null) {
			account2.setAcc_no(account.getAcc_no());
		}
		if (account.getBalance() != 0) {
			account2.setBalance(account.getBalance());
		}
		if (account.getIfsc_code() != null) {
			account2.setIfsc_code(account.getIfsc_code());
		}
		if (account2 != null) {
			account2.setBalance(0);
			return accountDao.updateAccount(account2);
		}
		return null;

	}

	public List<Account> getAllAccounts() {

		return accountDao.getAllAccounts();
	}

	public Account depositMoney(int customer_id, int account_no, double amount) {
		return accountDao.depositMoney(customer_id, account_no, amount);
	}

	public Account transferMoney(int customer_id, int sender, int reciever, double amount) {
		return accountDao.transferMoney(customer_id, sender, reciever, amount);
	}
}
