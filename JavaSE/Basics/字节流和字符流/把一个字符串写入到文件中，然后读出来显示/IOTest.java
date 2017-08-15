import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
/*把一个字符串写入到文件中，然后读出来显示*/
public class IOTest {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入字符串：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		/* PrintWriter(File file, String csn)
		 * 创建具有指定文件和字符集且不带自动刷行新的新 PrintWriter。*/
		PrintWriter pw = new PrintWriter("D:\\1.txt","utf-8");
		/*write(String s)写入字符串。*/
		pw.write(str);
		pw.close();
		/* FileInputStream 从文件系统中的某个文件中获得输入字节
		 * 
		 * InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 
		 * 读取字节并将其解码为字符。它使用的字符集可以由名称指定或显式给定，
		 * 或者可以接受平台默认的字符集。
		 * 
		 * BufferedReader从字符输入流中读取文本，缓冲各个字符，*/
		FileInputStream fi = new FileInputStream("D:\\1.txt"); 
		InputStreamReader is = new InputStreamReader(fi,"utf-8");
		BufferedReader br = new BufferedReader(is);
		
		String myStr = br.readLine();
		br.close();
		System.out.println(myStr);
	}
}

