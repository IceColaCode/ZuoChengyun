package string.practice;

/**
 * @ClassName P263_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/26 10:11
 * @Version 1.0
 **/
public class P263_2 {
	public static void main(String[] args) {

	}

	public static int getIndex(String[] strs, String str) {
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		int res = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (str.equals(strs[mid])) {
				right = mid - 1;
				res = mid;
			} else if (strs[mid] != null && strs[mid].compareTo(str) < 0) {
				left = mid + 1;
			} else if (strs[mid] != null && strs[mid].compareTo(str) > 0) {
				right = mid - 1;
			} else {
				i = mid;
				while (i > left && strs[--i] == null) {

				}
				if (strs[i] == null) {
					left = mid + 1;
				} else if (strs[i].equals(str)) {
					right = i -1;
					res = i;
				} else if (strs[i].compareTo(str) < 0) {
					left = mid + 1;
				} else {
					right = i - 1;
				}
			}
		}
		return res;

	}
}
