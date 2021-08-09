package dynamic;

/**
 * @ClassName P189_2
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 21:24
 * @Version 1.0
 **/
public class P189_2 {
	public static int process(int[] arr, int aim) {

		int[][] dp = new int[arr.length + 1][aim + 1];

		for (int i = 1; i <= aim; i++) {
			dp[arr.length][i] = -1;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			dp[i][0] = 0;
			for (int j = 1; j <= aim; j++) {
				if (j - arr[i] >= 0) {
					if (dp[i][j - arr[i]] == -1) {
						dp[i][j] = dp[i + 1][j];
					} else if (dp[i + 1][j] == -1) {
						dp[i][j] = dp[i][j - arr[i]] + 1;
					} else {
						dp[i][j] = Math.min(dp[i][j - arr[i]] + 1, dp[i + 1][j]);
					}
				} else {
					dp[i][j] = dp[i + 1][j];
				}
			}
		}
		return dp[0][aim];

	}

	public static void main(String[] args) {
		int[] arr = {5};
		int process = process(arr, 25);
		System.out.println(process);
	}
}
