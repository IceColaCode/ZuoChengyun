package string.practice;

/**
 * @ClassName P285_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/28 16:32
 * @Version 1.0
 **/
public class P285_2 {
	public static void main(String[] args) {
		String str = "ABCDB";
		int[][] dp = getDp(str);
		int[][] dp2 = getDp2(str);
		String palindrome = getPalindrome(dp, str);
		System.out.println(palindrome);
	}

	public static int[][] getDp(String str) {
		char[] chars = str.toCharArray();
		int[][] dp = new int[chars.length][chars.length];
		for (int i = chars.length - 2; i > -1; i--) {
			for (int j = i + 1; j < chars.length; j++) {
				if (j - i == 1) {
					if (chars[i] == chars[j]) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (chars[i] == chars[j]) {
						dp[i][j] = dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
					}
				}
			}
		}
		return dp;
	}

	public static int[][] getDp2(String string) {
		char[] str = string.toCharArray();
		int[][] dp = new int[str.length][str.length];
		for (int j = 1; j < str.length; j++) {
			dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
			for (int i=j-2;i>-1;i--){
				if (str[i] == str[j]){
					dp[i][j] = dp[i+1][j-1];
				} else {
					dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
				}
			}
		}
		return dp;
	}

	public static String getPalindrome(int[][] dp, String str) {
		char[] chars = str.toCharArray();
		int length = chars.length;
		int num = dp[0][length - 1];
		char[] res = new char[length + num];
		int resl = 0;
		int resr = res.length - 1;
		int i = 0;
		int j = length - 1;
		while (i<=j){
			if (chars[i] == chars[j]){
				res[resl++] = chars[i++];
				res[resr--] = chars[j--];
			} else if (dp[i][j] == dp[i+1][j] + 1){
				res[resl++] = chars[i];
				res[resr--] = chars[i++];
			} else if (dp[i][j] == dp[i][j-1] + 1){
				res[resl++] = chars[j];
				res[resr--] = chars[j--];
			}
		}

		return String.valueOf(res);
	}

}
