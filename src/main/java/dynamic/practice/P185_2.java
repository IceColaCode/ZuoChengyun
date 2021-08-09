package dynamic.practice;

/**
 * @ClassName P185_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/25 9:28
 * @Version 1.0
 **/
public class P185_2 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
		int i = minPathSum(matrix);
		System.out.println(i);
		int minPathSum2 = minPathSum2(matrix);
		System.out.println(minPathSum2);
	}

	public static int minPathSum(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (matrix == null || row == 0 || matrix[0] == null || col == 0) {
			return -1;
		}
		int[][] dp = new int[row][col];
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + matrix[0][i];
		}
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + matrix[i][0];
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public static int minPathSum2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return -1;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		boolean rowMore = row >= col;
		int more = rowMore ? row : col;
		int less = rowMore ? col : row;
		int[] dp = new int[less];
		dp[0] = matrix[0][0];
		for (int i = 1; i < less; i++) {
			dp[i] = dp[i - 1] + (rowMore ? matrix[0][i] : matrix[i][0]);
		}
		for (int i = 1; i < more; i++) {
			dp[0] = dp[0] + (rowMore ? matrix[i][0] : matrix[0][i]);
			for (int j = 1; j < less; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? matrix[i][j] : matrix[j][i]);
			}
		}
		return dp[less - 1];

	}

}
