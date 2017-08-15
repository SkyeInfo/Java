class QuickSort {
	public void quicksort(int[] a,int left,int right){
		int i,j,temp;
		int middle;
		i = left; j = right;
		middle = a[(i+j)/2];
		//每一次do-while都是一次排序
		do {
			//找左边小于中间值的量，找到即停止
			while (a[i] < middle && i < right) {
				i++;
			}
			//找右边大于中间值的量，找到即停止
			while (a[j] > middle && j > left) {
				j--;
			}
			//交换
			if (i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;//不加i++和j--的话很容易发生死循环
			}
		} while (i<=j);
		if (i < right) {
			quicksort(a, i, right);
		}
		if (j > left) {
			quicksort(a, left, j);
		}
	}
}
public class QuickSortTest{
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = new int[]{7,9,6,1,3,65,68,2,18,96,23,15};
		qs.quicksort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}