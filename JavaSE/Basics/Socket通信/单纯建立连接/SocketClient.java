import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	private String ClientIP = "localhost";
	private int port = 10010;
	private Socket socket;
	SocketClient() throws IOException{
		//实例化的过程中就已经在请求了
		socket = new Socket(ClientIP, port);
		System.out.println("与服务器已建立连接！");
	}
	public static void main(String[] args) throws IOException{
		new SocketClient();
	}
}
