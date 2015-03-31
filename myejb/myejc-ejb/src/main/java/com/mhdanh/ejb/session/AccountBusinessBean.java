package com.mhdanh.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.remote.AccountBusinessInterface;
import com.mhdanh.ejb.repository.AccountDao;

@Stateless(name = "accountBusinessBean")
public class AccountBusinessBean implements AccountBusinessInterface{

	@EJB
	private AccountDao accountDao;
	
	public boolean addAccount(Account acc) {
		return accountDao.addAccount(acc);
	}

	public boolean updateAccount(Account acc) {
		return accountDao.updateAccount(acc);
	}

	public boolean deleteAccount(Account acc) {
		return accountDao.deleteAccount(acc);
	}

	public List<Account> listAccount() {
		return accountDao.getAll();
	}
	

}
