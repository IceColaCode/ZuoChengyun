package sort;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/11 12:06
 * @Version 1.0
 **/
public class Test {





	public static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	public static void main(String[] args) {
		int a[] = {5, 1, 9, 3, 7, 5, 8, 5, 2, 6, 8, 4, 8, 2, 5};
//		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
