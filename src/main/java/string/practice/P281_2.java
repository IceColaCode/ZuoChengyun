package string.practice;

import java.util.*;

/**
 * @ClassName P281_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/28 11:28
 * @Version 1.0
 **/
public class P281_2 {
	public static void main(String[] args) {
		String[] strings = {"cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb"};
		Map<String, List<String>> nexts = getNexts("abc", strings);
		Map<String, Integer> minDistance = getMinDistance("abc", nexts);
		System.out.println();
	}

	public static Map<String, List<String>> getNexts(String start, String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		HashSet<String> set = new HashSet<String>();
		for (String str : strings) {
			set.add(str);
		}
		map.put(start, getNext(start.toCharArray(), set));
		for (String str : strings) {
			map.put(str, getNext(str.toCharArray(), set));
		}
		return map;
	}

	public static List<String> getNext(char[] chars, Set<String> set) {
		ArrayList<String> nexts = new ArrayList<>();
		char tmp;
		for (int i = 0; i < chars.length; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				if (j != chars[i]) {
					tmp = chars[i];
					chars[i] = j;
					if (set.contains(String.valueOf(chars))) {
						nexts.add(String.valueOf(chars));
					}
					chars[i] = tmp;
				}
			}
		}
		return nexts;
	}

	public static Map<String, Integer> getMinDistance(String start, Map<String, List<String>> nexts) {
		Map<String, Integer> res = new HashMap<>();
		res.put(start, 0);
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		HashSet<String> set = new HashSet<>();
		set.add(start);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> next = nexts.get(cur);
			for (String s : next) {
				if (!set.contains(s)) {
					res.put(s, res.get(cur) + 1);
					queue.add(s);
					set.add(s);
				}
			}
		}
		return res;
	}



}
