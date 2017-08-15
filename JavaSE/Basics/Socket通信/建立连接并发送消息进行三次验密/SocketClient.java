import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
	private String ClientIP = "localhost";
	private int port = 11000;
	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	SocketClient() throws IOException{
		init();
		waitData();
	}
	void init() throws IOException{
		//实例化的过程中就已经在请求了
		socket = new Socket(ClientIP, port);
		System.out.println("与服务器已建立连接！");
		
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
	}
	void waitData() throws IOException {
		int time = 1;
		System.out.println("请输入账号密码：");
		Scanner sc = new Scanner(System.in);
		while (time <= 3) {
			System.out.println("账号：");
			String username = sc.nextLine();
			System.out.println("密码：");
			String password = sc.nextLine();
			String info=username+";"+password;
			outputStream.writeUTF(info);
			/****等待回消息****/
			String callback = inputStream.readUTF();
			if ("登陆成功！".equals(callback)) {
				System.out.println("登陆成功！");
				return;
			}else if ("用户名输入错误！".equals(callback)) {
				System.out.println("用户名输入错误！");
			}else if ("密码错误！！！".equals(callback)) {
				System.out.println("密码错误！！！您还有"+(3-time)+"次输入机会！");
				time++;
			}
			else if ("非法用户！".equals(callback)) {
				System.out.println("非法用户！！！");
				time++;
			}else {
				System.out.println("系统错误！！！");
				System.exit(0);
			}
		}
		sc.close();
	}
	public static void main(String[] args) throws IOException{
		new SocketClient();
	}
}