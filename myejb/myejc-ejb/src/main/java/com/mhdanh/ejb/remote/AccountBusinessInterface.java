package com.mhdanh.ejb.remote;

import java.util.List;

import javax.ejb.Remote;

import com.mhdanh.ejb.domain.Account;

@Remote
public interface AccountBusinessInterface {
	boolean addAccount(Account acc);
	boolean updateAccount(Account acc);
	boolean deleteAccount(Account acc);
	List<Account> listAccount();
}
