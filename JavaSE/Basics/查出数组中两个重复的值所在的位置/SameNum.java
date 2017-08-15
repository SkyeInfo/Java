import java.util.ArrayList;
import java.util.List;

public class SameNum{
	public static void main(String[] args) {
		Integer[] a = new Integer[1000000];
		for (int i = 0; i < 1000000; i++) {
			a[i] = i + 1;
		}
		
		a[555] = 300;
		a[56] = 100;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			if (!list.contains(a[i])) {
				list.add(a[i]);
			}else {
				int j = list.indexOf(a[i]);
				System.out.println(j);
				System.out.println("第" + (j+1) + "个数和第" + (i+1) + "个数重复，为：" + a[i]);
			}
		}
	}
}