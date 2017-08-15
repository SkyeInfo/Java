class Fruit extends Thread
{
	 public Fruit(String name) {
		super(name);//调用父类的方法进行线程命名
	}
	 public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(i+" "+getName());
		}
	}
}
public class Threadtest{
	public static void main(String[] args) {
		//Thread(String name) 分配新的 Thread 对象。
		//下面这两个对象都是匿名对象
		new Fruit("苹果").start();
		new Fruit("山楂").start();
	}
}