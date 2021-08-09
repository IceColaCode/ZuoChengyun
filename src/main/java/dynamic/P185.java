package dynamic;

/**
 * @ClassName P185
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 18:08
 * @Version 1.0
 **/
public class P185 {
	public static int process(int[][] m) {

		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}

		boolean rowMore = m.length > m[0].length;
		int more = rowMore ? m.length : m[0].length;
		int less = rowMore ? m[0].length : m.length;
		int[] dp = new int[less];
		dp[0] = m[0][0];
		for (int i = 1; i < less; i++) {
			dp[i] = dp[i - 1] + (rowMore ? m[0][i] : m[i][0]);
		}
		for (int i = 1; i < more; i++) {
			dp[0] += rowMore ? m[i][0] : m[0][i];
			for (int j = 1; j < less; j++) {
				dp[j] = (rowMore ? m[i][j] : m[j][i]) + Math.min(dp[j], dp[j - 1]);
			}
		}
		return dp[less - 1];

	}

	public static void main(String[] args) {
		int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		int process = process(arr);
		System.out.println(process);
	}
}
