import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Test {
	public String PrintMinNumber(int [] numbers) {
		String s = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		//把数组值赋给list
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		//对list进行排序 第二个参数表示排序标准
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 +""+ o2;
				String s2 = o2 +""+ o1;
				return s1.compareTo(s2);
			}
		});
		//连接字符串
		for (int j = 0; j < list.size(); j++) {
			s = s + list.get(j);
		}
		return s;
	}
	public static void main(String[] args) {
		int[] a = new int[]{6,3,4,2,5,1};
		String str = new Test().PrintMinNumber(a);
		System.out.println("最小情况为："+str);
	}
}