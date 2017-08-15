/*
 * 求一个字符串的各个字符的排序的结果集
 * 
 * */
import java.util.*;
public class SetOfStrSort {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return list;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        list.addAll(set);
        Collections.sort(list);
        return list;
    }
    void fun(HashSet<String> set, char[] str, int k) {
        //如果字符串长度为0，直接把字符串添进list
    	if (k == str.length) {
    		set.add(new String(str));
            return;
        }
    	//不然的话
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(set, str, k + 1);
            swap(str, i, k);
        }
    }
    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
    public static void main(String[] args) {
		String string = "bca";
		System.out.println(new Errry().Permutation(string));
	}
}
