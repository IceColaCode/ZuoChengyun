package arr_matrix.practice;

/**
 * @ClassName P401
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/11 15:44
 * @Version 1.0
 **/
public class P401 {
	public static int findPartMin(int[] arr) {
		if (arr == null || arr.length < 2) {
			return -1;
		}
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;

	}
}
