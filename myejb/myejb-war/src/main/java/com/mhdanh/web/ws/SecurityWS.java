package com.mhdanh.web.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mhdanh.ejb.session.SecurityBussinessBean;

@Stateless
@Path("/security")
public class SecurityWS {
	
	private static final Logger logger = Logger.getLogger(SecurityWS.class.getName());
	
	@EJB
	private SecurityBussinessBean securityBussinessBean;
	
	@GET
	@Path("/allow-all")
	@Produces("application/json")
	public String allowAll() {
		logger.log(Level.WARNING,"allow-all in ws");
		securityBussinessBean.allowAll();
		return "allow all";
	}
	
	@GET
	@Path("/deny-all")
	@Produces("application/json")
	public String denyAll() {
		logger.log(Level.WARNING,"deny-all in ws");
		securityBussinessBean.denyAll();
		return "deny all";
	}
	
	@GET
	@Path("/admin-role")
	@Produces("application/json")
	public String adminRole() {
		logger.log(Level.WARNING,"admin-role in ws");
		securityBussinessBean.adminRole();
		return "admin role";
	}
	
}
