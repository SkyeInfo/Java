package com.ysk.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
	private static String ip = "127.0.0.1";
	private static int port = 9090;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket sc;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void init(){
		//创建Socket对象
		try {
			sc = new Socket(ip,port);
			dos = new DataOutputStream(sc.getOutputStream());
			dis = new DataInputStream(sc.getInputStream());
			System.out.println("已成功连接服务器！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void waitData() throws IOException{
		while (true) {
			//从控制台读取消息，发送
			String request = br.readLine();
			dos.writeUTF(request);
			dos.flush();
			
			//从socket管道中读取返回的消息，阻塞的方法
			String respons = dis.readUTF();
			System.out.println(respons);
		}
	}
	public void start() throws IOException{
		init();
		waitData();
	}
	public static void main(String[] args) throws IOException {
		new SocketClient().start();
		
	}
}
