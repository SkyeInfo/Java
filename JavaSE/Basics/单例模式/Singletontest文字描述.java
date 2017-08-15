/*什么是单例模式？
单例模式的主要作用是在Java程序中保证一个Class只有一个实例存在。
一般有如下几种形式：
1.第一种形式，先定义一个类，使其构造函数为private的，它有一个Static
的private的该类的变量，在类初始化时实例化，通过一个public的getInstance方法
获取对它的引用，继而调用其中的方法。*/
class Singletontest
{
	private Singletontest(){}
	private static Singletontest instance = new Singletontest();
	public static Singletontest getInstance(){
		return instance;
	}
}
/*******************************************************/
//2.第二种形式，
class Singletontest
{
	private static Singletontest instance = null;
	public static synchronized Singletontest getInstance(){
		if (instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}
}




//其他形式：使类的构造函数为private的，其所有方法为Static的