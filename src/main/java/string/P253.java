package string;

/**
 * @ClassName P253
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/16 15:17
 * @Version 1.0
 **/
public class P253 {
	public static boolean isDeformation(String str1, String str2) {

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		int[] map = new int[256];
		for (char ch : str1.toCharArray()) {
			map[ch]++;
		}
		for (char ch : str2.toCharArray()) {
			map[ch]--;
			if (map[ch] < 0){
				return false;
			}
		}
		return true;

	}
}
