package com.ysk.listen;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class ListenerJMS {
	private static ConnectionFactory factory = null;
	private static Connection conn = null;
	private static Session session = null;
	private static Destination L2S = null;
	private static Destination S2L = null;
	private static MessageConsumer consumer = null;
	private static MessageProducer producer = null;
	private static String Tid = null;
	static{
		try {
			//为该线程创建一个唯一标识符this.Tid
			Tid = new Date().getTime()+"";
			System.out.println("Tid为："+Tid);
			//创建一个ConnectionFactory,用于创建JMS连接factory
			factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			//创建一个JMS客户端到JMSprovider 的连接conn
			conn = factory.createConnection();
			//启动此连接
			conn.start();
			//创建一个用于消息发送和接受的会话session
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			L2S = session.createQueue("L2S");
			S2L = session.createQueue("S2L");
			
			//创建一个消息的接受者consumer，并规定此consumer只能接受固定ID的消息
			consumer = session.createConsumer(S2L, "MessageID = '" +Tid+"'");
			//创建一个消息的发送者producer
			producer = session.createProducer(L2S);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	//一个用于把String包装成Message的静态方法
	public static TextMessage createMessage(String message){
		try {
			return session.createTextMessage(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void send(Message message) {
		try {
			message.setStringProperty("MessageID", Tid);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public static Message recieve(){
		try {
			Message message = consumer.receive();
			return message;
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
