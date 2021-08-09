package dynamic.practice;

/**
 * @ClassName P192_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/25 15:08
 * @Version 1.0
 **/
public class P192_2 {
	public static void main(String[] args) {
		int walk = walk(5, 2, 3, 3);
		System.out.println(walk);
		int walk2 = walk2(5, 2, 3, 3);
		System.out.println(walk2);
	}

	public static int walk(int total, int init, int steps, int end) {
		if (total < 1 || init < 1 || init > total || steps < 0 || end < 1 || end > total) {
			return -1;
		}

		if (steps == 0) {
			return init == end ? 1 : 0;
		}

		if (init == 1) {
			return walk(total, init + 1, steps - 1, end);
		}
		if (init == total) {
			return walk(total, init - 1, steps - 1, end);
		}

		return walk(total, init - 1, steps - 1, end) + walk(total, init + 1, steps - 1, end);

	}

	public static int walk2(int total, int init, int steps, int end) {

		int[][] dp = new int[steps + 1][total + 1];
		dp[0][end] = 1;
		for (int i = 1; i <= steps; i++) {
			for (int j = 1; j <= total; j++) {
				if (j==1){
					dp[i][j] = dp[i-1][j+1];
				} else if (j==total){
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
			}
		}
		return dp[steps][init];
	}
}
