/*工厂模式举例，对于类Sample*/
//先创建一个专门生产Sample实例的工厂
public class FactoryTest
{
	public static ISample creator(int which){
		if(which==1){
			return new SampleA();
		}
		else if(which==2){
			return new SampleB();
		}
	}
}
//然后在创建ISample的实例时可以用
ISample sampleA = Factory.creator(1);