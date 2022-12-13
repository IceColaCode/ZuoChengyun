package arr_matrix.practice;

/**
 * @ClassName P397
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/10 17:17
 * @Version 1.0
 **/
public class P397_P398 {
	public static void main(String[] args) {
		int[] arr = {1, -2, 3, 5, -2, 6, -1};
		int i = maxSum(arr);
		System.out.println(i);
	}

	public static int maxSum(int[] arr) {
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += arr[i];
			res = Math.max(res, sum);
		}
		return res;
	}

	public static int maxMatrixSum(int[][] matrix) {
		int res = Integer.MIN_VALUE;
		int[] h = new int[matrix[0].length];
		int cur = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				for (int k = 0; k < h.length; k++) {
					h[k] += matrix[j][k];
					cur += h[k];
					res = Math.max(res, cur);
					cur = cur < 0 ? 0 : cur;
				}
			}
		}
		return res;

	}
}
