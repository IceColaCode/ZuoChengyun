package arr_matrix;

/**
 * @ClassName P372
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/3 10:48
 * @Version 1.0
 **/
public class P372 {
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 4, 2, 6, 7};
		int minLength = getMinLength(arr);
		System.out.println(minLength);
	}

	public static int getMinLength(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int min = arr[arr.length - 1];
		int noMinIndex = -1;
		for (int i = arr.length - 2; i != -1; i--) {
			if (arr[i] > min) {
				noMinIndex = i;
			} else {
				min = Math.min(min, arr[i]);
			}
		}
		if (noMinIndex == -1) {
			return 0;
		}
		int max = arr[0];
		int noMaxIndex = -1;
		for (int i = 1; i != arr.length; i++) {
			if (arr[i] < max) {
				noMaxIndex = i;
			} else {
				max = Math.max(max, arr[i]);
			}
		}
		return noMaxIndex - noMinIndex + 1;
	}
}
