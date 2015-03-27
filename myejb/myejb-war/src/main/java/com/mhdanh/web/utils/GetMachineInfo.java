package com.mhdanh.web.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetMachineInfo {
	static public String getIpAddress(){
		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostAddress();
		} catch (UnknownHostException e) {
			return "Don't have IP address";
		}
	}
}
