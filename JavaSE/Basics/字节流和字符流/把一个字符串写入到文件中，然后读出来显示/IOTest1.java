import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOTest1 {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入字符串：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		/*文件输出流是用于将数据写入 File 或 FileDescriptor 的输出流*/
		//创建文件输出流
		FileOutputStream fos  = new FileOutputStream("D:\\1.txt");
		/*write(int b)将指定字节写入此文件输出流。*/
		//写入文件输出流
		fos.write(str.getBytes("UTF-8"));
		fos.close();
		
		//创建写入文件的实例
		FileWriter fw = new FileWriter("D:\\1.txt");
		//写入文件
		fw.write(str);
		fw.close();

//		//创建要读文件的实例
//		FileReader fr = new FileReader("D:\\1.txt");
//		char[] buf = new char[1024];
//		//fr.read(buf);把字符读入数组，返回读取的字符数
//		int len = fr.read(buf);
//		String myStr = new String(buf,0,len);
//		System.out.println(myStr);
		
		FileInputStream fr = new FileInputStream("D:\\1.txt");
		byte[] buf = new byte[1024];
		int len = fr.read(buf);
		String myStr = new String(buf,0,len,"GBK");
		System.out.println(myStr);
	}

}