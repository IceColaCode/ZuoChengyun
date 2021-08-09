package tree;

/**
 * @ClassName P148
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/8 13:57
 * @Version 1.0
 **/
public class P148 {
	public static void main(String[] args) {

	}

	public static boolean isBstTree(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isBstTree(arr, 0, arr.length - 1);
	}

	public static boolean isBstTree(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		int less = -1;
		int more = end;
		for (int i = 0; i < end; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == 1 || more == end) {
			return isBstTree(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isBstTree(arr, start, less) && isBstTree(arr, more, end - 1);

	}

}
