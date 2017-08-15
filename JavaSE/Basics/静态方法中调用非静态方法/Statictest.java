/*静态方法中没法直接调用非静态方法，也没法直接调用非静态变量*/
class Statictest
{
	public String a = "123";
	public static String b = "456";
	public void sayHello(){
		System.out.println("HelloWorld");
	}
	public static void main(String[] args){
		//sayHello();
		Statictest st = new Statictest();
		st.sayHello();
		System.out.println(st.a);
		System.out.println(b);
	}
}