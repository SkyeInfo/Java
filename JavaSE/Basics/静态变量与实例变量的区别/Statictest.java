class  ValTestClass{
	static int i=0;
	static int x;//对于静态变量，编译器只对整个类创建了一个静态变量的副本，也就是只分配了一个内存空间，多个实例共享该内存。

	ValTestClass(){
		i++;
	}
	static int x(){
		return x;
	}
	static int i(){
		return i;
	}
	public  void  setX(int newX){
		x=newX;
	}	
}

public class Statictest{
	public static void main(String[] args ){

		ValTestClass test=new ValTestClass();
		ValTestClass test2=new ValTestClass();

		test.setX(5);
		System.out.println(ValTestClass.x());//无需创建类的实例就可以访问静态变量和静态方法
		System.out.println(test2.x());

		ValTestClass.x=10;
		System.out.println(test.x());
		System.out.println(test2.x());

		System.out.println(ValTestClass.i());
		
	}	

}
