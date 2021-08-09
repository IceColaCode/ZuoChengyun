package tree;

/**
 * @ClassName P142
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/7 15:23
 * @Version 1.0
 **/
public class P142 {
	public static void main(String[] args) {
		Node h1 = P107.reconFromLevel("1!2!3!4!5!6!7!8!9!10!#!#!#!#!#!#!#!#!#!#!#!");
		Node h2 = P107.reconFromLevel("2!4!5!8!#!#!#!#!#!");
		boolean contains = contains(h1, h2);
		System.out.println(contains);
	}

	public static boolean contains(Node h1, Node h2) {
		if (h2 == null) return true;
		if (h1 == null) return false;
		return isContains(h1, h2) || isContains(h1.left, h2) || isContains(h1.right, h2);
	}

	public static boolean isContains(Node h1, Node h2) {
		if (h2 == null) return true;
		if (h1 == null) return false;
		if (h1.value == h2.value) {
			return isContains(h1.left, h2.left) && isContains(h1.right, h2.right);
		} else {
			return false;
		}
	}
}
