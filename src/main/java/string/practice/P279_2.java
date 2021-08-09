package string.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName P279_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/26 11:33
 * @Version 1.0
 **/
public class P279_2 {
	public static void main(String[] args) {
		String[] strs = {"1","3","3","3","2","3","1"};
		Map<String, Map<String, Integer>> map = getMap(strs);
		System.out.println(map);
	}

	public static int findMinDistance(String[] strs, String str1, String str2) {
		if (str1 == null || str2 == null) {
			return -1;
		}
		if (str1.equals(str2)) {
			return 0;
		}
		int i = -1;
		int j = -1;
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < strs.length; k++) {
			if (strs[k].equals(str1)) {
				i = k;
				min = j == -1 ? min : Math.min(i - j, min);
			}
			if (strs[k].equals(str2)) {
				j = k;
				min = i == -1 ? min : Math.min(j - i, min);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static Map<String, Map<String, Integer>> getMap(String[] strs) {
		Map<String, Map<String, Integer>> res = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			Map<String, Integer> map = new HashMap<>();
			res.put(strs[i], map);
			for (int j = 0; j < strs.length; j++) {
				if (!strs[j].equals(strs[i])) {
					int min = map.getOrDefault(strs[j], -1);
					min = min == -1 ? Math.abs(i - j) : Math.min(min, Math.abs(i - j));
					map.put(strs[j], min);
				}
			}
		}
		return res;
	}
}
