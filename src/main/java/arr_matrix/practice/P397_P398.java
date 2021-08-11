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
		int[] arr = {1,-2,3,5,-2,6,-1};
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
}
