import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class Test {
//	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ArrayList<Integer> listresult = new ArrayList<Integer>();
//		for (int i = 0; i < input.length; i++) {
//			list.add(input[i]);
//		}
//		Collections.sort(list, new Comparator<Integer>() {
//			public int compare(Integer a0, Integer a1) {
//				return a0.compareTo(a1);
//			}
//		});
//		if (k > list.size()) {
//			return listresult;
//		}else{
//			for (int j = 0; j < k; j++) {
//				listresult.add(list.get(j));
//			}
//		}
//		return listresult;
//	}
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		Arrays.sort(input);
		ArrayList<Integer> listresult = new ArrayList<Integer>();
		if (k > input.length) {
			return listresult;
		}else{
			for (int j = 0; j < k; j++) {
				listresult.add(input[j]);
			}
		}
		return listresult;
	}
	public static void main(String[] args) {
		int[] a = new int[]{4,5,1,6,2,7,3,8};
		Test qqQwwer = new Test();
		System.out.println(qqQwwer.GetLeastNumbers_Solution(a, 4));
	}
}
