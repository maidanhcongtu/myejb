package com.mhdanh.web.websocket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.mhdanh.ejb.domain.Account;

public class AccountEncode implements Encoder.Text<Account> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public String encode(Account acc) throws EncodeException {
		JsonObject jsonObject = Json.createObjectBuilder()
		        .add("username", acc.getUsername())
		        .add("password", acc.getPassword()).build();
		    return jsonObject.toString();
	}

}
