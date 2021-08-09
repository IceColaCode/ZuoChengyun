package string;

import java.util.*;

/**
 * @ClassName P281
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/17 22:27
 * @Version 1.0
 **/
public class P281 {

	public HashMap<String, ArrayList<String>> getNexts(List<String> words) {
		HashSet<String> dict = new HashSet<>(words);
		HashMap<String, ArrayList<String>> nexts = new HashMap<>();
//		for (int i = 0; i < words.size(); i++) {
//			nexts.put(words.get(i), new ArrayList<>());
//		}
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), getNext(words.get(i), dict));
		}
		return nexts;
	}

	private ArrayList<String> getNext(String word, Set<String> dict) {
		ArrayList<String> res = new ArrayList<>();
		char[] chs = word.toCharArray();
		for (char cur = 'a'; cur <= 'z'; cur++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] != cur) {
					char tmp = chs[i];
					chs[i] = cur;
					if (dict.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					chs[i] = tmp;
				}
			}
		}
		return res;
	}

	public HashMap<String, Integer> getDistances(String start, HashMap<String, ArrayList<String>> nexts) {
		HashMap<String,Integer> distances = new HashMap<>();
		distances.put(start,0);
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		HashSet<String> set = new HashSet<>();
		set.add(start);
		while (!queue.isEmpty()){
			String cur = queue.poll();
			for (String str:nexts.get(cur)){
				if (!set.contains(str)){
					distances.put(str,distances.get(cur)+1);
					queue.add(str);
					set.add(str);
				}
			}
		}
		return distances;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("cab");
		list.add("acc");
		list.add("cbc");
		list.add("ccc");
		list.add("cac");
		list.add("cbb");
		list.add("aab");
		list.add("abb");
		list.add("abc");
		P281 p281 = new P281();
		HashMap<String, ArrayList<String>> nexts = p281.getNexts(list);
		HashMap<String, Integer> distances = p281.getDistances("abc", nexts);
		System.out.println();
	}

}
