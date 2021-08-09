package dynamic;

/**
 * @ClassName P179
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 17:25
 * @Version 1.0
 **/
public class P179 {
	public static int process(int n) {
		if (n < 5) return n;
		int[][] matrix = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
		int[][] powMatrix = powMatrix(matrix, n - 3);

		return 3 * powMatrix[0][0] + 2 * powMatrix[1][0] + powMatrix[2][0];
	}

	public static int[][] powMatrix(int[][] matrix, int n) {

		if (n == 1) {
			return matrix;
		}

		int[][] res = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}

		if ((n & 1) == 1) {
			res = mulMatrix(res, matrix);
		}

		int[][] m = powMatrix(matrix, n >> 1);
		int[][] powM = mulMatrix(m, m);

		res = mulMatrix(res, powM);
		return res;

	}

	public static int[][] mulMatrix(int[][] m1, int[][] m2) {
		int m1Row = m1.length;
		int m2Row = m2.length;
		int m2Col = m2[0].length;
		int[][] res = new int[m1Row][m2Col];

		for (int i = 0; i < m1Row; i++) {
			for (int j = 0; j < m2Col; j++) {
				for (int k = 0; k < m2Row; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		int process = process(8);
		System.out.println(process);
	}

}
