public class StrTongji
{
	public static void main(String[] args){
		String str = "woshi中国人233haha中国最棒";
		int zimu = 0;
		int hanzi = 0;
		int shuzi = 0;
		//字符串有length方法，数组有length属性
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if (ch>='0'&&ch<='9')
			{
				shuzi++;
			}else if ((ch >='a'&&ch<='z') || (ch>='A'&&ch<='Z'))
			{
				zimu++;
			}else{
				hanzi++;
			}
		}
		System.out.println("字母的数量为："+zimu);
		System.out.println("数字的数量为："+shuzi);
		System.out.println("汉字的数量为："+hanzi);
	}
}