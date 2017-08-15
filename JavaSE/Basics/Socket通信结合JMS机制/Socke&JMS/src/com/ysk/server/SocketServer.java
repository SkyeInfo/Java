package com.ysk.server;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SocketServer implements MessageListener{
	private static ConnectionFactory factory = null;
	private static Connection conn = null;
	private static Session session = null;
	private static Destination L2S = null;
	private static Destination S2L = null;
	private static MessageConsumer consumer = null;
	private static MessageProducer producer =null;
	private String Tid = null;
	private int i = 1;
	public SocketServer() {
		 try {
			factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			 conn = factory.createConnection();
			 conn.start();
			 
			 session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			 
			 L2S = session.createQueue("L2S");
			 S2L = session.createQueue("S2L");
			 
			 consumer = session.createConsumer(L2S);
			 
			 producer = session.createProducer(S2L);
			 
			 consumer.setMessageListener(this);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}
	
	public void send(Message message){
		try {
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void onMessage(Message message){
		
		try {
			if (message instanceof TextMessage) {
				TextMessage tmg = (TextMessage)message;
				Tid = tmg.getStringProperty("MessageID");
				System.out.println("Tid为："+Tid);
				String request = tmg.getText();
				System.out.println(request);
				
				Message mess = session.createTextMessage("信息"+i+"接收成功！");
				System.out.println("Tid为："+Tid);
				mess.setStringProperty("MessageID", Tid);
				this.send(mess);
				i++;
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SocketServer();
		System.out.println("MQ监听已开启！");
	}
}
