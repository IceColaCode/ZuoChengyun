package dynamic;

/**
 * @ClassName P192_2
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 22:21
 * @Version 1.0
 **/
public class P192_2 {
	public static int process(int total, int cur, int rest, int des) {

		int[] dp = new int[total + 1];
		dp[des] = 1;
		for (int i = 1; i <= rest; i++) {
			int leftUp = dp[1];
			dp[1] = dp[1];
			for (int j = 2; j <= total - 1; j++) {
				int tmp = dp[j];
				dp[j] = leftUp + dp[j + 1];
				leftUp = tmp;
			}
			dp[total] = leftUp;
		}
		return dp[cur];

	}

	public static void main(String[] args) {
		int process = process(5, 2, 3, 3);
		System.out.println(process);
	}
}
