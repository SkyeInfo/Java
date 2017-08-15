//比较经典的单例小程序
class Singleton1{
	private static Singleton1 instance = null;
	public static synchronized Singleton1 getInstance(){
		if (instance == null) {
			instance = new Singleton1();
			System.out.println("新创建了一个实例哦");
		}
		return instance;
	}
}
public class Singletontest1 {
	private static Singleton1 a = null;
	private static Singleton1 d = null;
	public static void main(String[] args) {
		Singleton1 b = a.getInstance();
		Singleton1 c = a.getInstance();
		System.out.println(b);
		System.out.println(c);
		System.out.println("---------------");
		Singleton1 e = d.getInstance();
		System.out.println(e);
	}
}