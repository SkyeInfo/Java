import java.util.Date;
public  class GetClasstest extends Date{
	public static void main(String[] args) {
		new GetClasstest().test();
		new GetClasstest().test1();
	}
	public void test(){
		System.out.println(super.getClass().getName());
	}
	public void test1(){
		System.out.println(super.getClass().getSuperclass().getName());
	}
}
