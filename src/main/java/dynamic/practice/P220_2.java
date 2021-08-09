package dynamic.practice;

/**
 * @ClassName P220_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/4/25 15:49
 * @Version 1.0
 **/
public class P220_2 {
	public static void main(String[] args) {
		String res = longestCommonString("1A2C3D4B56", "B1D23CA45B6A");
		System.out.println(res);
	}

	public static String longestCommonString(String str1, String str2) {
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return null;
		}

		int[][] dp = new int[str1.length()][str2.length()];
		if (str1.charAt(0) == str2.charAt(0)) {
			dp[0][0] = 1;
		}
		for (int i = 1; i < str2.length(); i++) {
			if (str1.charAt(0) == str2.charAt(i)) {
				dp[0][i] = 1;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}
		for (int i = 1; i < str1.length(); i++) {
			if (str2.charAt(0) == str1.charAt(i)) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		for (int i = 1; i < str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		int p = str1.length() - 1;
		int q = str2.length() - 1;
		int index = dp[p][q] - 1;
		char[] res = new char[dp[p][q]];
		while (index >= 0) {
			if (p > 0 && dp[p][q] == dp[p - 1][q]) {
				p--;
			} else if (q > 0 && dp[p][q] == dp[p][q - 1]) {
				q--;
			} else {
				res[index--] = str1.charAt(p);
				p--;
				q--;
			}
		}
		return String.valueOf(res);

	}
}
