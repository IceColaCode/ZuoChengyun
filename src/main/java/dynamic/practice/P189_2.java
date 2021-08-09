package dynamic.practice;

/**
 * @ClassName P189_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/25 10:54
 * @Version 1.0
 **/
public class P189_2 {
	public static void main(String[] args) {
		int[] arr = new int[]{5, 2, 3};
//		int i = minCoins(arr, 11);
//		System.out.println(i);
		int minCoins2 = minCoins2(arr, 11);
		System.out.println(minCoins2);
	}

	public static int minCoins2(int[] arr, int aim) {
		if (aim == 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		int n = 0;
		for (int i = 0; i <= aim; i++) {
			if (arr[0] * n == i){
				dp[i] = n;
				n++;
			} else {
				dp[i] = -1;
			}
		}


		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= aim; j++) {
				if (j - arr[i] > 0) {
					if (dp[j] == -1) {
						dp[j] = dp[j - arr[i]] == -1 ? -1 : dp[j - arr[i]] + 1;
					} else {
						dp[j] = dp[j - arr[i]] == -1 ? dp[j] : Math.min(dp[j - arr[i]] + 1, dp[j]);
					}
				}
			}
		}
		return dp[aim];

	}

//	public static int minCoins(int[] arr, int aim) {
//		return process(arr, 0, aim);
//	}
//
//	public static int process(int[] arr, int index, int aim) {
//		if (index == arr.length) {
//			return aim == 0 ? 0 : -1;
//		}
//		int n = 0;
//		int res = -1;
//		while (n * arr[index] <= aim) {
//			int process = process(arr, index + 1, aim - n * arr[index]);
//			if (process != -1) {
//				res = res == -1 ? n + process : Math.min(res, n + process);
//			}
//			n++;
//		}
//		return res;
//
//	}
//
//	public static int minCoins2(int[] arr, int aim) {
//
//		int N = arr.length;
//		int[][] dp = new int[N + 1][aim + 1];
//		for (int i = 1; i <= aim; i++) {
//			dp[N][i] = -1;
//		}
//		for (int i = N - 1; i >= 0; i--) {
//			for (int rest = 0; rest <= aim; rest++) {
//				dp[i][rest] = -1;
//				if (dp[i + 1][rest] != -1) {
//					dp[i][rest] = dp[i + 1][rest];
//				}
//				if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
//					if (dp[i + 1][rest] != -1) {
//						dp[i][rest] = Math.min(dp[i + 1][rest], dp[i][rest - arr[i]] + 1);
//					} else {
//						dp[i][rest] = dp[i][rest - arr[i]] + 1;
//					}
//				}
//			}
//		}
//		return dp[0][aim];
//
//	}
}
