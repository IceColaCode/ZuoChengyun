package stack_queue.practice;

import java.util.Stack;

/**
 * @ClassName P1
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/25 14:07
 * @Version 1.0
 **/
public class MinStack {
	public Stack<Integer> stack;
	public Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int num) {
		stack.push(num);
		if (minStack.isEmpty() || minStack.peek() >= num) {
			minStack.push(num);
		}
	}

	public int pop() {
		if (stack.isEmpty()) {
			throw new RuntimeException("MinStack is empty!");
		}
		int pop = stack.pop();
		if (pop == minStack.peek()) {
			minStack.pop();
		}
		return pop;

	}

	public int getMin() throws Exception {
		if (minStack.isEmpty()) {
			throw new RuntimeException("MinStack is empty!");
		}
		return minStack.peek();
	}

}
