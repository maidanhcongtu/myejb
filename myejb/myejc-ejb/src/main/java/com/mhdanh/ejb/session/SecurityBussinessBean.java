package com.mhdanh.ejb.session;

import java.awt.print.Book;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
public class SecurityBussinessBean {

	private static final Logger logger = Logger
			.getLogger(SecurityBussinessBean.class.getName());

	@PermitAll
	public void allowAll() {
		logger.log(Level.WARNING, "allow all");
	}

	@RolesAllowed({ "ADMIN" })
	public void adminRole() {
		logger.log(Level.WARNING,"admin role");
	}

	@DenyAll
	public void denyAll() {
		logger.log(Level.WARNING, "deny all");
	}

}
