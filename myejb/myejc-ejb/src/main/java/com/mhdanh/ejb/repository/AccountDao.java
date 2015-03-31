package com.mhdanh.ejb.repository;

import java.util.List;

import com.mhdanh.ejb.domain.Account;

public interface AccountDao {
	boolean addAccount(Account acc);
	boolean updateAccount(Account acc);
	boolean deleteAccount(Account acc);
	List<Account> getAll();
}
