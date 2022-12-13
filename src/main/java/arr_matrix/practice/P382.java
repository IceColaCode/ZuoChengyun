package arr_matrix.practice;

/**
 * @ClassName P382
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/9 17:11
 * @Version 1.0
 **/
public class P382 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 1, 1};
		int longestArr = LongestArr(arr, 3);
		System.out.println(longestArr);
	}

	public static int LongestArr(int[] arr, int k) {
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int len = 0;
		while (left != arr.length) {
			if (sum == k) {
				len = Math.max(len, right - left + 1);
				sum -= arr[left++];
			} else if (sum > k) {
				sum -= arr[left++];
			} else {
				if (right == arr.length - 1) {
					break;
				}
				sum += arr[++right];
			}
		}
		return len;
	}
}
