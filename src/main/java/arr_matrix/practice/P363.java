package arr_matrix.practice;

/**
 * @ClassName P363
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/4 10:03
 * @Version 1.0
 **/
public class P363 {
	public static void rotateMatrix(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		for (int i = tC; i < dC; i++) {
			int tmp = matrix[tR][tC + i];
			matrix[tR][tC + i] = matrix[dR - i][tC];
			matrix[dR - i][tC] = matrix[dR][dC - i];
			matrix[dR][dC - i] = matrix[tR + i][dC];
			matrix[tR + i][dC] = tmp;
		}
	}
}
