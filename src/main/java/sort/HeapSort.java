package sort;

/** 堆排序要点：
 * 1. 大顶堆就是堆顶的数最大，小顶堆堆顶的数最小
 * 2. 一般的排序从小到大，用大顶堆
 * 3. 大顶堆的定义是，每个元素必须大于其两个子节点
 */


public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {3, 5, 10, 9, 2, 8, 7, 4, 0, 6, 1};
		System.out.println("排序之前：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		// 堆排序
		heapSort(arr);

		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 堆排序
	 */
	private static void heapSort(int[] arr) {
		// 将待排序的序列构建成一个大顶堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapAdjust(arr, i, arr.length);
		}

		// 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
			heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
		}
	}

	/**
	 * 构建堆的过程
	 *
	 * @param arr 需要排序的数组
	 * @param i   需要构建堆的根节点的序号
	 * @param n   数组的长度
	 */
//	private static void heapAdjust(int[] arr, int i, int n) {
//		int child;
//		int fatherVal;
//		for (fatherVal = arr[i]; 2 * i + 1 < n; i = child) {
//			child = 2 * i + 1;
//
//			// 如果左子树小于右子树，则需要比较右子树和父节点
//			if (child != n - 1 && arr[child] < arr[child + 1]) {
//				child++; // 序号增1，指向右子树
//			}
//
//			// 如果父节点小于孩子结点，则需要交换
//			if (fatherVal < arr[child]) {
//				arr[i] = arr[child];
//			} else {
//				break; // 大顶堆结构未被破坏，不需要调整
//			}
//		}
//		arr[i] = fatherVal;
//	}
	private static void heapAdjust(int[] arr, int i, int n) {
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

	// 交换元素位置
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
