package com.mhdanh.ejb.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.remote.HelloBusinessInterface;
import com.mhdanh.ejb.utils.GetMachineInfo;

@Default
@Stateless(mappedName = "HelloSessionBeanEJB")
public class HelloSessionBean implements HelloBusinessInterface {

	@PersistenceContext(unitName = "persistentUnit")
	private EntityManager entityManager;

	public String sayHello(String name) {
		return GetMachineInfo.getIpAddress() + " say hello " + name + " at "
				+ new Date() + " !";
	}

	public List<Account> getAccount() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> query = builder.createQuery(Account.class);
		Root<Account> variableRoot = query.from(Account.class);
		query.select(variableRoot);
		return entityManager.createQuery(query).getResultList();
	}
}
