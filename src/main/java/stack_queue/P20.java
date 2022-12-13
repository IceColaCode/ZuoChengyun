package stack_queue;

import java.util.Stack;

// 单调栈
public class P20 {
    public int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[arr.length][2];
        Stack<Integer> monotorousStack = new Stack<>();
        monotorousStack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!monotorousStack.isEmpty() && arr[monotorousStack.peek()] > arr[i]){
                int popIndex = monotorousStack.pop();
                res[popIndex][0] = monotorousStack.isEmpty() ? -1 : arr[monotorousStack.peek()];

            }
        }

    }
}
