package sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/10 22:24
 * @Version 1.0
 **/

/**
 * @Author luoyan
 * @Description //TODO 算法书中解法
 * @Date 23:38 2020/4/10
 * @Param
 * @return
 **/

public class QuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = partition(arr, low, high);
		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot + 1, high);
	}

	public static int partition(int[] arr, int low, int high) {
		int i = low;
		int j = high + 1;
		int pivotkey = arr[low];
		while (true) {
			while (arr[++i] < pivotkey) {
				if (i == high) {
					break;
				}
			}
			while (arr[--j] > pivotkey) {
				if (j == low) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			swap(arr, i, j);
		}
		swap(arr, low, j);
		return j;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		int a[] = {5, 1, 9, 3, 7, 5, 8, 5, 2, 6, 8, 4, 8, 2, 5};
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
