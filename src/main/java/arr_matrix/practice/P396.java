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
		int[] arr = {2, 3, 6, 4, 25, 13, 5, 9, 8};
		modify(arr);
		System.out.println();
	}

	public static void modify(int[] arr) {
		int even = 0;
		int odd = 1;
		while (even < arr.length && odd < arr.length) {
			while ((arr[even] & 1) == 0) {
				even += 2;
				if (even >= arr.length){
					return;
				}
			}
			while ((arr[odd] & 1) == 1) {
				odd += 2;
				if (odd >= arr.length){
					return;
				}
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
