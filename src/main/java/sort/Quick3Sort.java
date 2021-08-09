package sort;

import java.util.Arrays;

/**
 * @ClassName Quick3Sort
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/11 15:08
 * @Version 1.0
 **/
// 三向切分快速排序
public class Quick3Sort {
	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int lt = low;
		int i = low + 1;
		int gt = high;
		int pivotkey = arr[low];
		while (i <= gt) {
			if (arr[i] < pivotkey) {
				QuickSort.swap(arr, lt++, i++);
			} else if (arr[i] > pivotkey) {
				QuickSort.swap(arr, i, gt--);
			} else {
				i++;
			}
		}
		quickSort(arr, low, lt - 1);
		quickSort(arr, gt + 1, high);
	}

	public static void main(String[] args) {

		int a[] = {5, 1, 9, 3, 7, 5, 8, 5, 2, 6, 8, 4, 8, 2, 5};
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
