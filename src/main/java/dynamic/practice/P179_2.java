package dynamic.practice;

import classic.KMP;

/**
 * @ClassName P179_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/24 16:46
 * @Version 1.0
 **/
public class P179_2 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,1},{1,0}};
		int[][] mul = pow(arr,2);
		System.out.println();

		int process = process(6);
		System.out.println(process);
	}
	public static int process(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] arr = new int[][]{{1, 1}, {1, 0}};
		int[][] pow = pow(arr, n - 1);
		return pow[0][0] + pow[1][0];
	}

	public static int[][] pow(int[][] arr, int p) {

		int len = arr.length;
		int[][] res = new int[len][len];
		int[][] tmp = arr;
		for (int i = 0; i < len; i++) {
			res[i][i] = 1;
		}
		while (p != 0) {
			if ((p & 1) == 1) {
				res = mul(res, tmp);
			}
			tmp = mul(tmp, tmp);
			p = p >> 1;
		}
		return res;
	}

	public static int[][] mul(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int col = arr2[0].length;
		int mulNum = arr2.length;
		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int k = 0; k < mulNum; k++) {
					res[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return res;
	}
}
