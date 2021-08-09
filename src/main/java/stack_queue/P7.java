package stack_queue;

import java.util.Stack;

/**
 * @ClassName P7
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/6 16:03
 * @Version 1.0
 **/
public class P7 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		solve(stack);
		System.out.println(stack);
	}

	public static void solve(Stack<Integer> stack) {

		if (stack.isEmpty()) {
			return;
		}

		int e = removeLastElement(stack);
		solve(stack);
		stack.push(e);

	}

	public static int removeLastElement(Stack<Integer> stack) {
		int res = stack.pop();
		if (stack.isEmpty()) {
			return res;
		}
		int last = removeLastElement(stack);
		stack.push(res);
		return last;
	}
}
