class  ValTestClass{
	int i=0;
	int x=1;

	ValTestClass(){
		i++;
	}
	int x(){
		return x;
	}
	int i(){
		return i;
	}
	public void setX(int newX){
		x=newX;
	}	
}

public class Instancetest{
	public static void main(String[] args ){
        
		ValTestClass test=new ValTestClass();
		ValTestClass test1=new ValTestClass();
		ValTestClass test2=new ValTestClass();

		test1.setX(2);//对于非静态变量，每个实例都有各自的变量内存单元
		System.out.println(test.x());
		System.out.println(test1.x());
		System.out.println(test2.x());
		test2.setX(3);
		System.out.println(test.x());
		System.out.println(test1.x());
		System.out.println(test2.x());

		test1.x=4;
		System.out.println(test.x());
		System.out.println(test1.x());
		System.out.println(test2.x());

		test2.x=5;
		System.out.println(test.x());
		System.out.println(test1.x());
		System.out.println(test2.x());

		System.out.println(test.i());
		System.out.println(test1.i());
		System.out.println(test2.i());
	}	

}
