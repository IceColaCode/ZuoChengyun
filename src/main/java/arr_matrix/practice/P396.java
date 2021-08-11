package arr_matrix.practice;

/**
 * @ClassName P394
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/10 16:01
 * @Version 1.0
 **/
public class P396 {
	public static void main(String[] args) {

	}
	public static void sort(int[] arr) {
		int even = 0;
		int odd = 1;
		while (even <= arr.length - 1 && odd <= arr.length - 1) {
			while ((arr[even] & 1) == 0) {
				even += 2;
			}
			while ((arr[odd] & 1) == 1) {
				odd += 2;
			}
			swap(arr, odd, even);
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
