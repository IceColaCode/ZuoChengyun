package arr_matrix.practice;

/**
 * @ClassName P378
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/9 16:41
 * @Version 1.0
 **/
public class P378 {
	public static void printUniqueTriad(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k < 0) {
			return;
		}

		for (int i = 0; i < arr.length - 2; i++) {
			printUniqueTwo(arr, i + 1, k, arr[i]);
		}

	}

	public static void printUniqueTwo(int[] arr, int start, int k, int first) {
		int sum = k - first;
		int end = arr[arr.length - 1];
		while (start != end) {
			if (arr[start] + arr[end] == sum) {
				System.out.println(first + " " + arr[start] + " " + arr[end]);
			} else if (arr[start] + arr[end] < sum) {
				start++;
			} else {
				end--;
			}
		}

	}
}
