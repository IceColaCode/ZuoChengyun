package stack_queue.practice;

import java.util.Stack;

public class P7 {
    public void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int bottom = getBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    public int getBottom(Stack<Integer> stack){
        int pop = stack.pop();
        if (stack.isEmpty()){
            return pop;
        } else {
            int bottom = getBottom(stack);
            stack.push(pop);
            return bottom;
        }
    }
}
