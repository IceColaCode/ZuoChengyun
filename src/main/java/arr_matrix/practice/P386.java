package arr_matrix.practice;

/**
 * @ClassName P386
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/10 15:20
 * @Version 1.0
 **/
public class P386 {
	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(h[i], sum);
		}
		sum = 0;
		int pre = 0;
		int res = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] h, int k) {
		int low = 0;
		int high = h.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (h[mid] >= k) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}
}
