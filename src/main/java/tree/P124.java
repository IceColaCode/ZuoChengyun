package tree;

/**
 * @ClassName P124
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/7 10:38
 * @Version 1.0
 **/
public class P124 {
	public static void main(String[] args) {
		Node head = P107.reconFromLevel("6!1!12!0!3!10!13!#!#!#!#!4!14!20!16!2!5!11!15!#!#!#!#!#!#!#!#!#!#!#!#!");
		int i = bstTopoSize1(head);
		System.out.println(i);
	}

	public static int bstTopoSize1(Node head) {
		if (head == null){
			return 0;
		}
		int max = maxTopo(head, head);
		max = Math.max(max,bstTopoSize1(head.left));
		max = Math.max(max,bstTopoSize1(head.right));
		return max;
	}

	public static int maxTopo(Node h, Node n) {
		if (h != null && n != null && isBstNode(h, n)) {
			return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
		}
		return 0;

	}

	public static boolean isBstNode(Node h, Node n) {
		if (h == null) {
			return false;
		}
		if (h == n) {
			return true;
		}
		return isBstNode(h.value > n.value ? h.left : h.right, n);

	}

}
