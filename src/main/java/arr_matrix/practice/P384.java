package arr_matrix.practice;

import java.util.HashMap;

/**
 * @ClassName P384
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/10 15:06
 * @Version 1.0
 **/
public class P384 {
	public static int maxLength(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxLen;
	}
}
