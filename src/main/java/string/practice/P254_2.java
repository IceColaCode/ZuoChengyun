package string.practice;

/**
 * @ClassName P254_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/26 9:24
 * @Version 1.0
 **/
public class P254_2 {
	public static void main(String[] args) {
		boolean reverse = isReverse("cdab", "abcd");
		System.out.println(reverse);
	}

	public static boolean isReverse(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		String str3 = str2 + str2;
		return getIndex(str3,str1) != -1;
	}

	public static int getIndex(String str1, String str2) {
		int[] next = getNext(str2);
		int j = 0;
		int k = 0;
		while (j < str1.length() && k < str2.length()) {
			if (str1.charAt(j) == str2.charAt(k)) {
				j++;
				k++;
			} else {
				if (next[k] == -1) {
					j++;
					k = 0;
				} else {
					k = next[k];
				}
			}
			if (k == str2.length()) {
				return j - k;
			}
		}
		return -1;

	}

	public static int[] getNext(String str) {
		int[] next = new int[str.length()];
		int j = 0;
		int k = -1;
		next[0] = -1;
		while (j < str.length()-1) {
			if (k == -1 || str.charAt(j) == str.charAt(k)) {
				next[++j] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}
}
