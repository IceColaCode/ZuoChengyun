package string.practice;

/**
 * @ClassName P316_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/1 16:19
 * @Version 1.0
 **/
public class P316_1 {
	public static void main(String[] args) {
		boolean match = isMatch("abc", "abc.*");
		System.out.println(match);
	}

	public static boolean isMatch(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] p = exp.toCharArray();
		return process(s, p, 0, 0);
	}

	public static boolean process(char[] s, char[] e, int si, int ei) {
		if (e.length == ei) {
			return s.length == si;
		}
		if (ei == e.length - 1 || e[ei + 1] != '*') {
			if (si != s.length && s[si] == e[ei] || e[ei] == '.') {
				return process(s, e, si + 1, ei + 1);
			} else {
				return false;
			}
		}
		while (si != s.length && s[si] == e[ei] || e[ei] == '.') {
			if (process(s, e, si, ei + 2)) {
				return true;
			}
			si++;
		}
		return process(s, e, si, ei + 2);
	}
}

