package sort;

/**
 * 堆排序要点：
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
            heapify(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapify(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }


    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        while (2 * index + 1 < heapSize) {
            int child = 2 * index + 1;
            if (child + 1 < heapSize && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[index] > arr[child]) {
                break;
            }
            swap(arr, index, child);
            index = child;
        }
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
