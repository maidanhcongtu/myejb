package com.mhdanh.web.ws;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.remote.AccountBusinessInterface;

@Stateless
@Path("/account")
public class AccountWS {
	
	private static final Logger logger = Logger.getLogger(AccountWS.class.getName());
	
	@EJB
	private AccountBusinessInterface accountBusinessInterface;
	
//	@GET
//	@Produces("text/html")
//	@Path("/text")
//	public Response hello(){
//		return Response.status(200).entity("hello anh en again").build();
//	}
//	
//	@GET
//	@Produces("application/json")
//	@Path("/text-kiz")
//	public Object json() {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("name", "mhdanh again");
//		return map;
//	}
	
	@GET
	@Path("/string-text")
	@Produces("text/html")
	public String hello(){
		return "mai huu danh";
	}
	
	@GET
	@Path("/string-object")
	@Produces("text/html")
	public String objectText(){
		return "mai huu danh object";
	}
	
	@GET
	@Path("/string-json")
	@Produces("application/json")
	public Object json(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "mhdanh ds sdfdf");
		return map;
	}
	
	
	@GET
	@Produces("application/json")
	@Path("/add")
	public String addAccount() {
		logger.log(Level.WARNING,"add account error");
		try {
			Account acc = new Account();
			acc.setUsername("admin");
			acc.setPassword("123");
			acc.setFullname("Mai Huu Danh");
			acc.setBirthDay(new Date());
			accountBusinessInterface.addAccount(acc);
			return "done";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/list")
	public Object listAccount() {
		try {
			return accountBusinessInterface.listAccount();
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
}
