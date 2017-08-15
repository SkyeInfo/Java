class People
{
	int age = 10;
}
public class Yinyong{
	public static void main(String[] args){
		People p = new People();
		p.age = 20;
		System.out.println(p.age);
		change(p);
		System.out.println(p.age);

	}
	static void change(People p1){
		p1.age = 30;
	}
}