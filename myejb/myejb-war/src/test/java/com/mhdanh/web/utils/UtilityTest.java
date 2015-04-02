package com.mhdanh.web.utils;



import junit.framework.TestCase;


public class UtilityTest extends TestCase{
	
	public void testGetFileNameFromPath() {
		Utility utility = new Utility();
		assertEquals("Hydrangeas.jpg", utility.getFileNameFromPath("D:\\opt\\myejb\\avatar\\Hydrangeas.jpg"));
	}
}
