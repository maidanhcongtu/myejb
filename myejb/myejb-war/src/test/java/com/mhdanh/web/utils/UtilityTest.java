package com.mhdanh.web.utils;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mhdanh.ejb.domain.Account;
import com.mhdanh.ejb.domain.Role;


public class UtilityTest extends TestCase{
	
	public void testGetFileNameFromPath() {
		Utility utility = new Utility();
		assertEquals("Hydrangeas.jpg", utility.getFileNameFromPath("D:\\opt\\myejb\\avatar\\Hydrangeas.jpg"));
	}
	
	@Test
	public void testJson() {
		Account acc = new Account();
		acc.setId(1L);
		acc.setUsername("mhdanh");
		acc.setPassword("abc123");
		acc.setBirthDay(new Date());
		acc.setFullname("mai huu danh");
		
		JsonObject jsonObject = Json.createObjectBuilder()
		        .add("username", acc.getUsername())
		        .add("password", acc.getPassword()).build();
		
		JsonArray arry = Json.createArrayBuilder().add(jsonObject).add(jsonObject).build();
		
		System.out.println(arry.toString());
	}
	
	@Test
	public void testGsonStrategy() {
		Account acc = new Account();
		acc.setId(1L);
		acc.setUsername("mhdanh");
		acc.setPassword("abc123");
		acc.setBirthDay(new Date());
		acc.setFullname("mai huu danh");
		
		Account acc1 = new Account();
		acc1.setId(2L);
		acc1.setUsername("nhdieu");
		acc1.setPassword("123");
		acc1.setBirthDay(new Date());
		acc1.setFullname("nguyen nhu dieu");
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(acc);
		accounts.add(acc1);
		
		Gson gson = new GsonBuilder().serializeNulls().setExclusionStrategies(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				if(f.getName().equals("username")) {
					return true;
				}
				return false;
			}
			
			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				return false;
			}
		}).create();
		
		Gson gson2 = new Gson();
		
		String str = gson.toJson(accounts);
		System.out.println("-------");
		System.out.println(str);
		
	}
	
	@Test
	public void testListRole() {
		List<Role> roles = new ArrayList<>();
		Role role1 = new Role();
		role1.setId(1);
		role1.setRoleName("Admin");
		
		Gson gson = new GsonBuilder().serializeNulls().setExclusionStrategies(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				if(f.getName().equals("username")) {
					return true;
				}
				return false;
			}
			
			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				return false;
			}
		}).create();
		
		System.out.println("*****");
		System.out.println(gson.toJson(role1));
		
	}
	
	
}
