import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
	int port = 10010;
	private ServerSocket server = null;
	private Socket socket;
	SocketServer() throws IOException {
		server = new ServerSocket(port);
		System.out.println("服务端正在监听...");
		//accept()侦听并接受到此套接字的连接
		socket = server.accept();
		System.out.println("与客户端建立连接成功！");
	}
	public static void main(String[] args) throws IOException {
		new SocketServer();
	}
}