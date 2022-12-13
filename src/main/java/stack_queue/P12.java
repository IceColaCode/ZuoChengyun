package stack_queue;

import java.util.Stack;

/**
 * @ClassName P12
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/6 17:49
 * @Version 1.0
 **/
public class P12 {
	public static void main(String[] args) {

	}

	public void sortStack(Stack<Integer> stack){
		if (stack.isEmpty()){
			return;
		}
		Stack<Integer> help = new Stack<>();
		while (!stack.isEmpty()){
			int pop = stack.pop();
			while (!help.isEmpty() && pop > help.peek()){
				stack.push(help.pop());
			}
			help.push(pop);
		}
		while (!help.isEmpty()){
			stack.push(help.pop());
		}
	}
}
