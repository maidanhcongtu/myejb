package com.mhdanh.ejb.session;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
	    activationConfig = 
	    {
	        @ActivationConfigProperty(propertyName = "destinationType", 
	                    propertyValue = "javax.jms.Queue"),
	        @ActivationConfigProperty(propertyName = "destination", 
	        			propertyValue = "jms/Queue") 
	    })
public class SimpleMessageBean implements MessageListener{

	private final Logger logger = Logger.getLogger(SimpleMessageBean.class.getName());
	
	public void onMessage(Message inMessage) {
		TextMessage msg = null;
	    try {
	        if (inMessage instanceof TextMessage) {
	            msg = (TextMessage) inMessage;
	            logger.info("MESSAGE BEAN: Message received: " +
	                msg.getText());
	        } else {
	            logger.warning("Message of wrong type: " +
	                inMessage.getClass().getName());
	        }
	    } catch (JMSException e) {
	        e.printStackTrace();
	    } catch (Throwable te) {
	        te.printStackTrace();
	    }
		
	}

}
