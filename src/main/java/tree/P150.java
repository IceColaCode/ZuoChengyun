package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName P150
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/8 14:16
 * @Version 1.0
 **/
public class P150 {
	public static void main(String[] args) {

	}

	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		boolean isLeaf = false;
		Node l = null;
		Node r = null;
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((isLeaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				isLeaf = true;
			}
		}
		return true;

	}
}
