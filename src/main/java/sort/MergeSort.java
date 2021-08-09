package sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/11 12:14
 * @Version 1.0
 **/
public class MergeSort {
	static int[] help;

	public static void mergeSort(int[] arr) {
		help = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = low + (high - low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			help[k] = arr[k];
		}
		for (int k = low;k<=high;k++){
			if (i>mid) arr[k] = help[j++];
			else if (j>high) arr[k] = help[i++];
			else if (help[i]<help[j]) arr[k] = help[i++];
			else arr[k] = help[j++];
		}
	}

	public static void main(String[] args) {

		int a[] = {5, 1, 9, 3, 7, 5, 8, 5, 2, 6, 8, 4, 8, 2, 5};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
}
