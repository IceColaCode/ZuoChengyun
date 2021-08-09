package arr_matrix;

/**
 * @ClassName P382
 * @Description TODO
 * @Author hylz
 * @Date 2021/1/29 15:38
 * @Version 1.0
 **/
public class P382 {
	public static void main(String[] args) {
		int[] arr = {1,2,1,2,1,1,4,1,2,3,4,1};
		int longestSum = findLongestSum(arr, 5);
		System.out.println(longestSum);
	}

	public static int findLongestSum(int[] arr, int sum) {
		int max = 0;
		int cur = arr[0];
		int left = 0;
		int right = 0;
		int len = arr.length;
		while (left < len) {
			if (cur < sum) {
				if (right == len - 1) {
					break;
				}
				cur += arr[++right];
			} else if (cur == sum) {
				max = Math.max(max, right - left + 1);
				if (right == len - 1) {
					break;
				}
				cur -= arr[left++];
				cur += arr[++right];
			} else {
				cur -= arr[left++];
			}
		}
		return max;

	}
}
