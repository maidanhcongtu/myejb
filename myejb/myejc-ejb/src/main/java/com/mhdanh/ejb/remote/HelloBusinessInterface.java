package com.mhdanh.ejb.remote;
import java.util.List;

import javax.ejb.Remote;

import com.mhdanh.ejb.domain.Account;

@Remote
public interface HelloBusinessInterface {
	public String sayHello(String name);

	public List<Account> getAccount();
}
