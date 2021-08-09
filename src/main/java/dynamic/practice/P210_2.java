package dynamic.practice;

/**
 * @ClassName P210_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/26 17:37
 * @Version 1.0
 **/
public class P210_2 {
	public static void main(String[] args) {

	}


	public static int[] getdp(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}



}
