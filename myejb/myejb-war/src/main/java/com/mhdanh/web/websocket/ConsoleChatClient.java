package com.mhdanh.web.websocket;

import java.io.Console;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.json.Json;
import javax.json.JsonObject;

public class ConsoleChatClient {
	public static void main(final String[] args) throws InterruptedException, URISyntaxException {
 
		final ChatClient clientEndPoint = new ChatClient(new URI("ws://localhost:9080/myejb/ws/account"));
		clientEndPoint.addMessageHandler(new ChatClient.MessageHandler() {
			
			@Override
			public void handleMessage(String message) {
				System.out.println(message);
			}
		});
		clientEndPoint.sendMessage(stringToJsonMessage("mhdanh", "okman"));
		Thread.sleep(100000);
	}
 
	private static String stringToJsonMessage(final String user, final String message) {
		return Json.createObjectBuilder().add("sender", user).add("message", message).build().toString();
	}
 
	private static String jsonMessageToString(final String response, final String roomName) {
		JsonObject root = Json.createReader(new StringReader(response)).readObject();
		String message = root.getString("message");
		String sender = root.getString("sender");
		String received = root.getString("received");
		return String.format("%s@%s: %s [%s]", sender, roomName, message, received);
	}
}
