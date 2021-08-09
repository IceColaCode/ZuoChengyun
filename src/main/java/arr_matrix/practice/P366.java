package arr_matrix.practice;

import java.util.Arrays;

/**
 * @ClassName P366
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/4 15:04
 * @Version 1.0
 **/
public class P366 {
	public static void main(String[] args) {
		int[] arr = {5,6,9,1,23,42,6,15,3};
		int[] minKNumsByHeap = getMinKNumsByHeap(arr, 5);
		System.out.println(Arrays.toString(minKNumsByHeap));
	}
	public static int[] getMinKNumsByHeap(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int[] kHeap = new int[k];
		for (int i = 0; i < k; i++) {
			headInsert(kHeap, arr[i], i);
		}
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	}

	public static void headInsert(int[] arr, int value, int index) {
		arr[index] = value;
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public static void heapify(int[] arr, int i, int n) {
		while (2 * i + 1 < n) {
			int child = 2 * i + 1;
			if (child < n - 1 && arr[child] < arr[child + 1]) {
				child++;
			}
			if (arr[i] > arr[child]) {
				break;
			}
			swap(arr, i, child);
			i = child;
		}
	}

	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
