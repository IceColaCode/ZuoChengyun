package arr_matrix.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName P372
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/9 11:47
 * @Version 1.0
 **/
public class P372 {
	public static void printOverHalfNum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int res = arr[0];
		int cnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == res) {
				cnt++;
			} else {
				if (cnt > 1) {
					cnt--;
				} else {
					res = arr[i];
					cnt = 1;
				}
			}
		}
		cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == res) {
				cnt++;
			}
		}
		if (cnt > arr.length / 2) {
			System.out.println(res);
		} else {
			System.out.println("no such number");
		}

	}

	public static void printKMajor(int[] arr, int K) {
		if (K < 2) {
			return;
		}
		HashMap<Integer, Integer> cands = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				cands.put(arr[i], cands.get(arr[i]) + 1);
			} else {
				if (cands.size() == K - 1) {
					allCandsMinusOne(cands);
				} else {
					cands.put(arr[i], 1);
				}
			}
		}
		HashMap<Integer, Integer> reals = getReals(arr, cands);
		boolean hasPrint = false;
		for (Map.Entry<Integer, Integer> set : cands.entrySet()) {
			Integer key = set.getKey();
			if (reals.get(key) > arr.length / K) {
				hasPrint = true;
				System.out.println(key + " ");
			}
		}
		System.out.println(hasPrint ? " " : "no such number");
	}

	public static void allCandsMinusOne(HashMap<Integer, Integer> cands) {
		for (Map.Entry<Integer, Integer> set : cands.entrySet()) {
			Integer key = set.getKey();
			Integer value = set.getValue();
			if (value == 1) {
				cands.remove(key);
			} else {
				cands.put(key, value - 1);
			}
		}
	}

	public static HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
		HashMap<Integer, Integer> reals = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				reals.put(arr[i], reals.getOrDefault(arr[i], 0) + 1);
			}
		}
		return reals;
	}

}
