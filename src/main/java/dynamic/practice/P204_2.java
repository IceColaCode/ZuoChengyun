package dynamic.practice;

/**
 * @ClassName P204_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/26 15:56
 * @Version 1.0
 **/
public class P204_2 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 2, 5, 1};
		int maxScore = process(arr, 1, arr.length - 2);
		System.out.println(maxScore);
	}

//	public static int maxScore(int[] arr) {
//		return 0;
//	}
//
	public static int process(int[] arr, int left, int right) {

		if (left == right) {
			return arr[left - 1] * arr[left] * arr[right + 1];
		}
		int maxScore = Math.max(process(arr, left + 1, right) + arr[left] * arr[left - 1] * arr[right + 1],
				process(arr, left, right - 1) + arr[left - 1] * arr[right] * arr[right + 1]);
		for (int i = left + 1; i < right; i++) {
			maxScore = Math.max(process(arr, i + 1, right) + process(arr, left, i - 1) + arr[left - 1] * arr[i] * arr[right + 1], maxScore);
		}
		return maxScore;

	}
}
