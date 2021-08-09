package string.practice;

/**
 * @ClassName P294_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/31 15:22
 * @Version 1.0
 **/
public class P294_1 {
	public static void main(String[] args) {
		int value = getValue(5);
		System.out.println(value);
	}

	public static int getValue(int N) {
		if (N < 1) {
			return -1;
		}
		if (N <= 3) {
			return N;
		}
		return process(N);
	}

	public static int process(int N) {
		int[][] matrix = {{1, 1}, {1, 0}};
		int[][] matrixPow = matrixPow(matrix, N - 2);
		return 2 * matrixPow[0][0] + matrixPow[1][0];
	}

	public static int[][] matrixPow(int[][] matrix, int N) {
		if (N == 1) {
			return matrix;
		}
		int[][] res = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			res[i][i] = 1;
		}
		if ((N & 1) == 1) {
			res = matrixMul(res, matrix);
		}
		int[][] m = matrixPow(matrix, N >> 1);
		int[][] mul = matrixMul(m, m);
		res = matrixMul(res, mul);
		return res;
	}

	public static int[][] matrixMul(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
}
