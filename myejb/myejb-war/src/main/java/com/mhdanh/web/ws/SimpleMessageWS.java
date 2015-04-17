package com.mhdanh.web.ws;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/simple-message")
public class SimpleMessageWS implements Serializable{

	private static final Logger logger = Logger.getLogger(SimpleMessageWS.class.getName());
	
	private static final long serialVersionUID = 1L;

//  can use anotation
//	@Resource(mappedName="java:/ConnectionFactory")
//	private ConnectionFactory connectionFactory;
//  can not use queue
//	@Resource(name="testQueue")
//	private Queue queue;
	
	@Path("/index")
	@Produces("text/html")
	@GET
	public String getText() {
		return "hello message";
	}
	
	@Path("/send")
	@Produces("text/html")
	@GET
	public String sendMessage() throws JMSException, NamingException {
		
		// Gets the JNDI context
        Context jndiContext = new InitialContext();
        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory)
                jndiContext.lookup("/ConnectionFactory");
        logger.log(Level.WARNING,"Faceotyrconnection:" + connectionFactory);

		Queue queue = (Queue) jndiContext.lookup("jms/Queue");
		logger.log(Level.WARNING,"Quere:" + queue);
		
		Connection connection = connectionFactory.createConnection();
		logger.log(Level.WARNING,"connection:" + connection);
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		logger.log(Level.WARNING,"session:" + session);
		MessageProducer messageProducer = session.createProducer(queue);
		logger.log(Level.WARNING,"message producer:" + messageProducer);
		TextMessage message = session.createTextMessage();
		logger.log(Level.WARNING,"message:" + message);
		for (int i = 0; i < 10; i++) {
		    message.setText("This is message " + (i + 1));
		    messageProducer.send(message);
		}
		return "send msg success";
	}
	
}
