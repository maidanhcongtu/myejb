package com.mhdanh.web.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.remote.HelloBusinessInterface;



@Stateless
@Path("/demo")
public class Demo {

	@EJB
	HelloBusinessInterface helloBusinessInterface;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Object showAll() {
		return helloBusinessInterface.sayHello("Calisa");
	}
	
	@GET
	@Path("/account")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> showAccount() {
		return helloBusinessInterface.getAccount();
	}
	
}
