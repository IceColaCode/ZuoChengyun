package string.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName P297_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/31 17:03
 * @Version 1.0
 **/
public class P297_1 {
	public static void main(String[] args) {

	}
	public static String minOrder(String[] strs){
		Arrays.sort(strs,new MyComparator());
		StringBuilder builder = new StringBuilder();
		for (String str:strs){
			builder.append(str);
		}
		return String.valueOf(builder);
	}
}

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return (o1+o2).compareTo(o2+o1);
	}
}
