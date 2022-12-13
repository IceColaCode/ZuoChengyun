package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName P26
 * @Description TODO
 * @Author hylz
 * @Date 2022/12/13 22:24
 * @Version 1.0
 **/
public class P26 {
	public int maxMatrixSize(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < height.length; j++) {
				height[j] = matrix[i][j] == 0 ? 0 : 1 + height[j];
			}
			max = Math.max(max, maxRecFromBottom(height));
		}
		return max;
	}

	public int maxRecFromBottom(int[] height) {
		Stack<List<Integer>> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] < height[stack.peek().get(0)]) {
				List<Integer> popList = stack.pop();
				int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
				for (int pop : popList) {
					max = Math.max(max, (i - leftIndex - 1) * height[pop]);
				}
			}
			if (!stack.isEmpty() && height[stack.peek().get(0)] == height[i]){
				stack.peek().add(i);
			} else {
				List<Integer> newList = new ArrayList<>();
				newList.add(i);
				stack.push(newList);
			}
		}
		return max;
	}
}
