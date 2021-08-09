package arr_matrix.practice;

/**
 * @ClassName P361
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/2 16:37
 * @Version 1.0
 **/
public class P361 {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		if (tR == dR) {
			while (tC != dC) {
				System.out.println(matrix[tR][tC++]);
			}
		} else if (tC == dC) {
			while (tR != dR) {
				System.out.println(matrix[tR++][tC]);
			}
		} else {
			int curR = tR;
			int curC = tC;
			while (curC != dC) {
				System.out.println(matrix[tR][curC++]);
			}
			while (curR != dR) {
				System.out.println(matrix[curR++][dC]);
			}
			while (curC != tC) {
				System.out.println(matrix[dR][curC--]);
			}
			while (curR != tR) {
				System.out.println(matrix[curR--][tC]);
			}
		}

	}

}
