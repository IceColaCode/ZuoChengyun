package arr_matrix.practice;

/**
 * @ClassName P371
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/4 16:30
 * @Version 1.0
 **/
public class P371 {
	public static int getMinLength(int[] arr) {

		int noMinIndex = -1;
		int min = arr[arr.length - 1];
		for (int i = arr.length - 1; i > -1; i--) {
			if (arr[i] > min) {
				noMinIndex = i;
			} else {
				min = Math.min(min, arr[i]);
			}
		}
		if (noMinIndex == -1) {
			return 0;
		}
		int noMaxIndex = -1;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < max) {
				noMaxIndex = i;
			} else {
				max = Math.max(max, arr[i]);
			}
		}
		return noMaxIndex - noMinIndex + 1;
	}
}
