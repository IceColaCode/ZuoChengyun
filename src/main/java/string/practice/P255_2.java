package string.practice;

/**
 * @ClassName P255_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/25 14:48
 * @Version 1.0
 **/
public class P255_2 {
	public static void main(String[] args) {

	}

	public static int convert(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] chars = str.toCharArray();
		if (!isValid(chars)) {
			return 0;
		}
		boolean isPositive = chars[0] != '-';
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		for (int i = isPositive ? 0 : 1; i < chars.length; i++) {
			int cur = '0' - chars[i];
			if (res < minq || (res == minq && chars[i] < minr)) {
				return 0;
			}
			res = res * 10 + cur;
		}
		if (isPositive && res == Integer.MIN_VALUE) {
			return 0;
		}
		return isPositive ? -res : res;

	}

	public static boolean isValid(char[] chars) {
		if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
			return false;
		}
		if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
			return false;
		}
		if (chars[0] == '0' && chars.length > 1) {
			return false;
		}
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] < '0' || chars[i] > '9') {
				return false;
			}
		}
		return true;
	}

}
