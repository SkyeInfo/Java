
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileChuli {
	public static void main(String[] args) {
		Scanner sc  =new Scanner(System.in);
		String string = sc.nextLine();
		//写入文件
		try {
			FileWriter fw = new FileWriter("D:\\test.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(string);
			bw.flush();
			bw.close();
			fw.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		try{
			//从文件中读
			FileReader fr = new FileReader("D:\\test.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			System.out.println(str);
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
