import java.util.*;
public class StrTongji1
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		//str中有两个Tab三个空格。/*因为EditPlus的问题，空格在Tab之前或之间时会在保存时发生错误，导致最终统计数量出问题，建议在eclipse中进行测试*/
		String str = "abbcccdddd我我我我我你你你你你你他他他他他他他111122223333$$%%%^^^^&&&&&&***((()))		   ";
		System.out.println("字符串为："+str);
		System.out.println();
		HashMap<Character,Integer> map = new HashMap();
		int num = 0;
		map.clear();
		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			//.get(Object key);返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。 
			Object ob = map.get(ch);
			if(ob != null){
				num= (Integer)ob + 1;
				map.remove(ch);
				map.put(ch, num);
			}else{
				//.put(key,value);将指定的值与此映射中的指定键关联
				map.put(ch,1);
			}
		}
		System.out.println("/******输出Map<Key,Value>******/");
		System.out.println();
		System.out.println("-------第一种方式---------");
		for (Map.Entry<Character , Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey() + ":" +entry.getValue());
		}
		System.out.println("-------第二种方式----------");
		//iterator()返回在此 set 中的元素上进行迭代的迭代器。
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			char ch1 = (Character)it.next();
			Integer value = map.get(ch1);
			System.out.println(ch1 + ":" +value);
		}
	}
}
