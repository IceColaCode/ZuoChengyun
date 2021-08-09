package string.practice;

/**
 * @ClassName P310_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/1 14:29
 * @Version 1.0
 **/
public class P310_1 {
	public static int findShortestStr(String str1, String str2) {
		int[] map = new int[256];
		int match = 0;
		int left = 0;
		int right = 0;
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < c2.length; i++) {
			map[c2[i]]++;
			match++;
		}
		while (right < c1.length) {
			map[c1[right]]--;
			if (map[c1[right]] >= 0) {
				match--;
			}
			if (match == 0){
				while (map[c1[left]] < 0) {
					map[c1[left]]++;
					left++;
				}
				res = Math.min(right - left + 1, res);
				map[c1[left]]++;
				left++;
				match++;
			}
			right++;
		}
		return res;
	}

	public static void main(String[] args) {
		int shortestStr = findShortestStr("baabbbcbabbbcbabbc", "ac");
		System.out.println(shortestStr);
	}
}
