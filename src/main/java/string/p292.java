package string;

import java.util.Stack;

/**
 * @ClassName p292
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/20 15:38
 * @Version 1.0
 **/
public class p292 {
	public static void main(String[] args) {
		int res = calculate("48*((70-65)-43)+8*1");
		System.out.println(res);
	}
	public static int calculate(String s) {
		return calculate(s, 0)[0];
	}

	// 带括号四则运算 计算从k位置开始的表达式，遇到')'或表达式完停止
	public static int[] calculate(String s, int k) {
		int res = 0;
		int num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		char[] sarr = s.toCharArray();
		int i = k;
		for (; i < sarr.length && sarr[i] != ')'; i++) {
			if (sarr[i] >= '0') {
				num = num * 10 + sarr[i] - '0';
			}
			// 当前遇到非数字字符 | 到达公式结尾 | 下一个是')'都需要进行累计
			if ((!Character.isDigit(sarr[i]) && sarr[i] != ' ') || i == sarr.length - 1 || sarr[i + 1] == ')') {
				// 遇到左括号时，开始递归过程
				if (sarr[i] == '(') {
					int[] arr = calculate(s, i + 1);
					num = arr[0];
					i = arr[1];
				}
				if (sign == '+' || sign == '-') {
					stack.push(sign == '+' ? num : -num);
				} else if (sign == '*' || sign == '/') {
					int top = stack.pop();
					stack.push(sign == '*' ? top * num : top / num);
				}

				sign = sarr[i];
				num = 0;
			}
		}

		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return new int[] { res, i };
	}
}