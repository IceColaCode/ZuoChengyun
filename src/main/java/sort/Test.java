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

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int pivot = partition(arr, L, R);
            quickSort(arr, L, pivot - 1);
            quickSort(arr, pivot + 1, R);
        }
    }

    public static int partition(int[] arr, int L, int R) {
        int less = L - 1;
        while (L < R) {
            if (arr[L] <= arr[R]) {
                swap(arr, ++less, L++);
            } else {
                L++;
            }
        }
        swap(arr, ++less, R);
        return less;
    }


    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 9, 3, 7, 5, 8, 5, 2, 6, 8, 4, 8, 2, 5};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
