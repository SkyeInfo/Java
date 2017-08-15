import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinTranToHanzi {
	private static String name;
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		String result = null;
		FileInputStream fin = new FileInputStream("D:\\xingming.txt");
		InputStreamReader isr = new InputStreamReader(fin,"utf-8");
//		FileReader fr = new FileReader("D:\\xingming.txt");
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fou = new FileOutputStream("D:\\pinyin.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fou);
		BufferedWriter bw = new BufferedWriter(osw);
		while ((name = br.readLine())!=null) {
			System.out.println(name);
			result = change(name,"0");
			System.out.println("姓名全拼为："+result);
			bw.write(result+"\n");
		}
		bw.close();
		osw.close();
		fou.close();
		br.close();
		isr.close();
		fin.close();
//		System.out.println("请输入汉字姓名：");
//		String name = sc.nextLine();
//      sc.close();
	}
	public static String change(String chinese, String firstChar){
		String pinyin = "";
		char[] nameChar = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < chinese.length(); i++) {
			String str = String.valueOf(nameChar[i]);
			if (str.matches("[\\u4e00-\\u9fa5]")) {
				try{if (firstChar.equals("1")) {
					pinyin += PinyinHelper.toHanyuPinyinStringArray(nameChar[i],defaultFormat)[0].charAt(0);
				}else if (firstChar.equals("0")) {
					pinyin += PinyinHelper.toHanyuPinyinStringArray(nameChar[i],defaultFormat)[0];
				}}
				catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			}else if(str.matches("[a-z]")||str.matches("A-Z")||str.matches("0-9")){
				pinyin += str;
			}
		}

		return pinyin.toLowerCase();
	}
}
