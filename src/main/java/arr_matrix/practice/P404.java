package arr_matrix.practice;

/**
 * @ClassName P404
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/12 10:58
 * @Version 1.0
 **/
public class P404 {
	public static void main(String[] args) {
		int[][] matrix = {{219, 405, 538, 845, 971}, {148, 558}, {52, 99, 348, 691}};
		printTopK(matrix,5);
	}

	public static void printTopK(int[][] matrix, int topK) {
		int heapSize = matrix.length;
		HeapNode[] heap = new HeapNode[heapSize];
		for (int i = 0; i != heapSize; i++) {
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		System.out.println("TOP " + topK + " : ");
		for (int i = 0; i != topK; i++) {
			int arrNum = heap[0].arrNum;
			int index = --heap[0].index;
			System.out.println(heap[0].value);
			if (index >= 0) {
				heap[0] = new HeapNode(matrix[arrNum][index], arrNum, index);
			} else {
				swap(heap,0,--heapSize);
			}
			heapify(heap, 0, heapSize);
		}

	}

	public static void heapInsert(HeapNode[] heap, int i) {
		while (i > 0) {
			int parent = (i - 1) / 2;
			if (heap[parent].value >= heap[i].value) {
				return;
			} else {
				swap(heap, parent, i);
				i = parent;
			}
		}
	}

	public static void heapify(HeapNode[] heap, int i, int n) {
		while (2 * i + 1 < n) {
			int child = 2 * i + 1;
			if (child + 1 < n && heap[child].value < heap[child + 1].value) {
				child++;
			}
			if (heap[i].value >= heap[child].value) {
				return;
			} else {
				swap(heap, i, child);
				i = child;
			}
		}
	}

	public static void swap(HeapNode[] heap, int i, int j) {
		HeapNode tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
}

class HeapNode {
	public int value;
	public int arrNum;
	public int index;

	public HeapNode(int value, int arrNum, int index) {
		this.value = value;
		this.arrNum = arrNum;
		this.index = index;
	}
}