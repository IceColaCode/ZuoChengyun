package dynamic.practice;

/**
 * @ClassName P230_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/6 14:31
 * @Version 1.0
 **/
public class P230_2 {
	public static void main(String[] args) {
		int minCost1 = minCost1("ab12cd3", "abcdf", 5, 3, 2);
		System.out.println(minCost1);
	}

	public static int minCost1(String str1, String str2, int ic, int dc, int rc) {

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= str2.length(); i++) {
			dp[0][i] = i * ic;
		}
		for (int i = 1; i <= str1.length(); i++) {
			dp[i][0] = i * dc;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				dp[i][j] = Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic);
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
				} else {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + rc);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}
}
