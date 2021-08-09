package dynamic.practice;

/**
 * @ClassName P223_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/4/25 18:16
 * @Version 1.0
 **/
public class P223_2 {
	public static void main(String[] args) {
		String res = process("1AB2345CD", "12345EF");
		System.out.println(res);
	}

	public static String process(String str1, String str2) {
		int max = 0;
		int m = 0;
		int[][] dp = new int[str1.length()][str2.length()];
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(0)) {
				dp[i][0] = 1;
				max = 1;
				m = i;
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			if (str1.charAt(0) == str2.charAt(i)) {
				dp[0][i] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > max) {
						max = dp[i][j];
						m = i;
					}
				}
			}
		}
		return str1.substring(m - max + 1, m + 1);

	}
}
