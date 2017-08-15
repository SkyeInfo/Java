
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileChuli {
	public static void main(String[] args) {
		Scanner sc  =new Scanner(System.in);
		String string = sc.nextLine();
		//写入文件
		try {
			FileOutputStream fos = new FileOutputStream("D:\\test.txt");
			OutputStreamWriter out = new OutputStreamWriter(fos);
			BufferedWriter bWriter = new BufferedWriter(out);
			bWriter.write(string);
			bWriter.flush();
			bWriter.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try{
			//从文件中读
			FileInputStream fin = new FileInputStream("D:\\test.txt");
			InputStreamReader inr = new InputStreamReader(fin);
			BufferedReader bis = new BufferedReader(inr);

			String str1 = bis.readLine();
			System.out.println(str1);

			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
