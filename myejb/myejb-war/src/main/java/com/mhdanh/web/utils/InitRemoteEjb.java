package com.mhdanh.web.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InitRemoteEjb {
	public static <T> T getRemoteSession(Class T, String lookupName) {
		try {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.RemoteInitialContextFactory");
			prop.put("java.naming.provider.url", "ejbd://localhost:4201");
			Context context = new InitialContext(prop);
			T remoteSession = (T) context.lookup(lookupName);
			context.close();
			return remoteSession;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
