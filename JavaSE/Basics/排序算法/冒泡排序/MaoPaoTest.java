public class MaoPaoTest {
	public static void main(String[] args) {
		int[] arr = new int[]{10000,7,9,5,1,6,5,8,15,23,46,21,39,99,1000};
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for (int m = 0; m < arr.length; m++) {
			System.out.print(arr[m]+" ");
		}
	}
}