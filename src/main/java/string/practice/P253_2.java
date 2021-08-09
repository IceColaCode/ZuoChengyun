package string.practice;

/**
 * @ClassName P253_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/25 14:13
 * @Version 1.0
 **/
public class P253_2 {
	public static void main(String[] args) {

	}

	public static boolean isDeformation(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int[] map = new int[256];
		for (char ch : chars1) {
			map[ch]++;
		}
		for (char ch:chars2){
			if (map[ch]-- == 0){
				return false;
			}
		}
		return true;

	}

}
