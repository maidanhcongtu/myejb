package com.mhdanh.ejb.session;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TimerSessionBean {

	private static Logger logger = Logger.getLogger(TimerSessionBean.class.getName());
	
	@Schedule(second = "*", minute = "*", hour = "*")
	public void scheduleTest() {
		logger.log(Level.WARNING,"excute at: again");
	}
	
}
