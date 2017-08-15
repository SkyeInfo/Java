package com.ysk.listen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
	private static int port = 9090;

	public static void main(String[] args) {
		try {
			ServerSocket ssc = new ServerSocket(port);
			System.out.println("Socket服务端开始监听！");
			while (true) {
				Socket sc = ssc.accept();
				System.out.println("已建立一个Client连接！");

				new ListenerThread(sc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
