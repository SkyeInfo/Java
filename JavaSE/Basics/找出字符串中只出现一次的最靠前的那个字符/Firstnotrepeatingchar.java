import java.util.ArrayList;

public class Firstnotrepeatingchar {
	public int FirstNotRepeatingChar(String str) {
		int m,n,x;
		char a = 0;
		int result = 0;
		ArrayList<Character> listc = new ArrayList<Character>(10000);
		ArrayList<Integer> listi = new ArrayList<Integer>(10000);
		for (int k = 0; k < 10000; k++) {
			listi.add(1);
		}
		if (str.length() == 0) {
			result = -1;
		}else {
			for (int i = 0; i < str.length(); i++) {
				a = str.charAt(i);
				if (listc.contains(a)) {
					m = listc.indexOf(a);
					n = listi.get(m);
					n++;
					listi.set(m, n);
				}else {
					listc.add(a);
				}
			}
			for (int p = 0; p < listi.size(); p++) {
				x = listi.get(p);
				if(x == 1){
					a = listc.get(p);
					break;
				}
			}
			result = str.indexOf(String.valueOf(a));
		}
		return result;
	}
	public static void main(String[] args) {
		Firstnotrepeatingchar tr = new Firstnotrepeatingchar();
		String ssString = "";
		System.out.println(tr.FirstNotRepeatingChar(ssString));
	}
}
