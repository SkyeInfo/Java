class Fruit1 implements Runnable{
	String name;
	public Fruit1(String name) {
		this.name = name;
	}
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i+" "+name);
			//Thread.yield();暂停当前正在执行的线程对象，并执行其他线程。
			//Thread.yield();
		}
	}
}
public class Runnabletest{
	public static void main(String[] args) {
		Fruit1 t1 = new Fruit1("苹果");
		Fruit1 t2 = new Fruit1("山楂");
		
		//Thread(Runnable target) 分配新的 Thread 对象。
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		th1.start();
		th2.start();
	}
}