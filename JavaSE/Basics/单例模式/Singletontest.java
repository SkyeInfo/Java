//单例模式
class Singleton
{
	int i = 1;
	private Singleton(){}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance(){
		return instance;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
public class Singletontest{

	private static Singleton a;
	private static Singleton d;
	public static void main(String[] args) {
		Singleton b = a.getInstance();
		Singleton c = a.getInstance();
		System.out.println(a.getInstance());
		System.out.println(b);
		System.out.println(c);
		b.setI(2);
		System.out.println(c.getI());
		System.out.println("--------------------------");
		Singleton e = d.getInstance();
		System.out.println(e);
		System.out.println(b==e);
	}
}