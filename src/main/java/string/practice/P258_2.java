package string.practice;

/**
 * @ClassName P258_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/25 16:19
 * @Version 1.0
 **/
public class P258_2 {
	public static void main(String[] args) {
		String s = strStatistic("aaabbadddffc");
		System.out.println(s);
	}

	public static String strStatistic(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		char cur = chars[0];
		int num = 1;
		sb.append(cur).append('_');
		for (int i = 1; i < chars.length; i++) {
			if (cur == chars[i]) {
				num++;
			} else {
				sb.append(num).append('_').append(chars[i]).append('_');
				cur = chars[i];
				num = 1;
			}
		}
		sb.append(num);
		return sb.toString();
	}

	public static char process(String str, int index) {
		if (str == null || index < 0) {
			return '=';
		}
		boolean isLetter = true;
		char cur = ' ';
		int sum = 0;
		int num = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '_') {
				isLetter = !isLetter;
			} else if (isLetter) {
				sum += num;
				if (sum > index) {
					return cur;
				}
				num = 0;
				cur = chars[i];
			} else {
				num = num * 10 + chars[i] - '0';
			}
		}
		return sum + num > index ? cur : 0;
	}

}
