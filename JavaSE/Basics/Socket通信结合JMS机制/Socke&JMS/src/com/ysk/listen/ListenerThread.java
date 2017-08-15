package com.ysk.listen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class ListenerThread extends Thread{
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	public ListenerThread(Socket socket){
		 try {
			this.socket = socket;
			 this.dis = new DataInputStream(this.socket.getInputStream());
			 this.dos = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 this.start();
	}
	
	public void run(){
		while (true) {
			if (this.socket.isClosed()) {
				break;
			}
			try {
				String request = this.dis.readUTF().toString();
				System.out.println(request);
				
				//把从socket中获取到的消息包装成Message
				Message message = ListenerJMS.createMessage(request);
				ListenerJMS.send(message);
				
				TextMessage tmg = (TextMessage) ListenerJMS.recieve();
				String respons = tmg.getText();
				
				this.dos.writeUTF(respons);
				this.dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
