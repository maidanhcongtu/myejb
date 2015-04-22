package com.mhdanh.web.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.remote.AccountBusinessInterface;

@ServerEndpoint(value = "/ws/account", encoders = {AccountEncode.class})
@Stateless
public class ManageAccountWebSocket {
	
	private static Set<Session> clients = Collections
			.synchronizedSet(new HashSet<Session>());
	
	@EJB
	private AccountBusinessInterface accountBusinessInterface;

	// handle all message from client
	@OnMessage
	public void handleOnMsg(String msg, Session session) throws IOException, EncodeException {
		synchronized (clients) {
			for (Session client : clients) {
				List<Account> accounts = accountBusinessInterface.listAccount();
				Gson gson = new Gson();
				String strAccounts = gson.toJson(accounts);
				client.getBasicRemote().sendObject(accounts.get(0));
			}
		}
	}

	// handle new connect from client
	@OnOpen
	public void handleOnOpen(Session session) {
		clients.add(session);
	}

	// handle client disconnect to server
	@OnClose
	public void handleOnClose(Session session) {
		clients.remove(session);
	}
}
