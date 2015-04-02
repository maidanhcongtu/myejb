package com.mhdanh.ejb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhdanh.ejb.domain.Account;

@Stateless
public class AccountDaoImpl implements AccountDao{
	
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean addAccount(Account acc) {
		try {
			entityManager.persist(acc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING,"error addAccount ",e);
		}
		return false;
	}

	public boolean updateAccount(Account acc) {
		try {
			entityManager.merge(acc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING,"error updateAccount ",e);
		}
		return false;
	}

	public boolean deleteAccount(Account acc) {
		try {
			entityManager.remove(acc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING,"error deleteAccount ",e);
		}
		return false;
	}

	public List<Account> getAll() {
		try {
			List<Account> accounts = entityManager.createQuery("SELECT acc FROM Account acc",Account.class).getResultList();
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING,"error listAccount ",e);
		}
		return new ArrayList<Account>();
	}

}
