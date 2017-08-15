/*String是不可以被更改的，而StringBuffer是可以被更改的
有的时候为什么用StringBuffer而不用String？
1.节省空间，更快
*/
public class Stringbuffer
{
	public static void main(String[] args){
		final StringBuffer sb = new StringBuffer("AAAAAAAAAAAAA");
		sb.append("BBBBB");
		final StringBuffer sb1 = new StringBuffer("AAAAAAAAAAAAA");
		sb1.insert(3,"BBBBB");
		System.out.println(sb.toString());
		System.out.println(sb1.toString());

		StringBuffer sb2 = new StringBuffer();
		sb2.append("Hello");
		System.out.println("sb2:"+sb2);
		changesb2(sb2);
		System.out.println("改变后sb2:"+sb2);

		String str = "Hello";
		System.out.println("str:"+str);
		changestr(str);
		System.out.println("改变后str:"+str);
	}
	static void changesb2(StringBuffer sss){
		sss.append("HelloWorld");
	}
	static void changestr(String ss){
		ss = "HelloWorld";
	}
}