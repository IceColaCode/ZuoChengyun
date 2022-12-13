package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 单调栈
public class P20 {
	public static void main(String[] args) {
		P20 instance = new P20();
		System.out.println(Arrays.toString(instance.getNearLessNoRepeat(new int[]{3, 4, 1, 5, 6, 2, 7})));
		System.out.println(Arrays.toString(instance.getNearLessNoRepeat2(new int[]{3, 4, 1, 5, 6, 2, 7})));
	}

	public int[][] getNearLessNoRepeat(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[0][0];
		}
		int[][] res = new int[arr.length][2];
		Stack<Integer> monotorousStack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			while (!monotorousStack.isEmpty() && arr[monotorousStack.peek()] > arr[i]) {
				int popIndex = monotorousStack.pop();
				res[popIndex][0] = monotorousStack.isEmpty() ? -1 : monotorousStack.peek();
				res[popIndex][1] = i;
			}
			monotorousStack.push(i);
		}
		while (!monotorousStack.isEmpty()) {
			int popIndex = monotorousStack.pop();
			res[popIndex][0] = monotorousStack.isEmpty() ? -1 : monotorousStack.peek();
			res[popIndex][1] = -1;
		}
		return res;
	}

	public int[][] getNearLessNoRepeat2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[0][0];
		}
		int[][] res = new int[arr.length][2];
		Stack<ArrayList<Integer>> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				ArrayList<Integer> popIndex = stack.pop();
				for (int index : popIndex) {
					res[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
					res[index][1] = i;
				}
			}
			if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
				stack.peek().add(i);
			} else {
				ArrayList newList = new ArrayList();
				newList.add(i);
				stack.push(newList);
			}
		}
		while (!stack.isEmpty()) {
			ArrayList<Integer> popIndex = stack.pop();
			for (int index : popIndex){
				res[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
				res[index][1] = -1;
			}
		}
		return res;
	}

}
