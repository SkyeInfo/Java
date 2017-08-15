import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
	int port = 11000;
	private ServerSocket server = null;
	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	SocketServer() throws IOException {
		init();
		waitData();
	}
	void init() throws IOException{
		server = new ServerSocket(port);
		System.out.println("服务端正在监听...");
		//accept()侦听并接受到此套接字的连接
		socket = server.accept();
		System.out.println("与客户端建立连接成功！");	
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
	}
	void waitData() throws IOException{
		System.out.println("正在等待消息...");

		String username = "ysk";
		String password = "123";
		int time = 1;
		while(time <= 3){
			String info = inputStream.readUTF();
			String[] a = info.split(";");
			if (a[0].equals(username)){
				if (a[1].equals(password)) {
					outputStream.writeUTF("登陆成功！");
					System.out.println("客户端已登陆成功！");
				}else {
					if(time < 3){
						outputStream.writeUTF("密码错误！！！");
						System.out.println("客户端输入密码错误！");
						time++;
					}else {
						outputStream.writeUTF("非法用户！");
						System.out.println("客户端已连续输错三次密码，拒绝登陆！");
					}
				}
			}else {
				outputStream.writeUTF("用户名输入错误！");
				System.out.println("客户端输入用户名错误！");
			}
		}

	}
	public static void main(String[] args) throws IOException {
		try {
			new SocketServer();
		} catch (Exception e) {
			System.out.println("Socket连接已被重置");
		}
	}
}