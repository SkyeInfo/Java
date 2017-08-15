public class Test {
	public String change(StringBuffer strbuf){
		String string = strbuf.toString();
		String result = string.replaceAll(" ", "%");
		return result;
	}
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer();
		s.append("Hello World Hi I am Skye.");
		System.out.println("原字符串："+s);
		String ss= new Test().change(s);
		System.out.println("替换后："+ss);
	}
}