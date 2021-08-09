package dynamic.practice;

/**
 * @ClassName P236_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/6 16:48
 * @Version 1.0
 **/
public class P236_2 {
	public static void main(String[] args) {
		int[][] map = {{-2, -3, 3}, {-5, -10, 1}, {0, 30, -5}};
		int res = process(map);
		System.out.println(res);
	}

	public static int process(int[][] map) {
		int row = map.length;
		int col = map[0].length;
		int[][] dp = new int[row][col];
		dp[row - 1][col - 1] = Math.max(1, 1 - map[row - 1][col - 1]);
		for (int i = col - 2; i >= 0; i--) {
			dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - map[row - 1][i]);
		}
		for (int i = row - 2; i >= 0; i--) {
			dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - map[i][col - 1]);
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				if (dp[i + 1][j] - map[i][j] < 0 || dp[i][j + 1] - map[i][j] < 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = Math.min(dp[i + 1][j] - map[i][j],dp[i][j + 1] - map[i][j]);
				}
			}
		}
		return dp[0][0];
	}
}
