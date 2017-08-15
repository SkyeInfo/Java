class integerTest{
	static int a = Integer.MAX_VALUE;
	static int b = Integer.MIN_VALUE;
	static String str = "123456789";
	public static void main(String[] args){
		int str1 = Integer.parseInt(str);
		str1 = str1 + 1;	
		System.out.println("a="+a+",b="+b+",str1="+str1);
	}
}