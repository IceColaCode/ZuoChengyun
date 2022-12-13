package arr_matrix.practice;

/**
 * @ClassName P392
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/10 15:34
 * @Version 1.0
 **/
public class P392 {
	public static int smallSum(int[] arr) {
		return func(arr, 0, arr.length - 1);
	}

	public static int func(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = (l + r) / 2;
		return func(arr, l, mid) + func(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] h = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int index = 0;
		int sum = 0;
		while (i <= m && j <= r) {
			if (arr[i] <= arr[j]) {
				sum += arr[i] * (r - j + 1);
				h[index++] = arr[i++];
			} else {
				h[index++] = arr[j++];
			}
		}
		while (i <= m) {
			h[index++] = arr[i++];
		}
		while (j <= r) {
			h[index++] = arr[j++];
		}
		for (int k = 0; k < h.length; k++) {
			arr[l++] = h[k];
		}
		return sum;
	}
}
