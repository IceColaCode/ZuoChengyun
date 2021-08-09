package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName P132
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/12 20:30
 * @Version 1.0
 **/
public class P132 {
	public static void printByLevel(Node head) {
		if (head == null) return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		Node last = head;
		Node nlast = null;
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nlast = node.right;
			}
			if (node == last) {
				System.out.println(node.value + "\n");
				last = nlast;
			} else {
				System.out.print(node.value + " ");
			}
		}
	}

	public static void zigzagPrint(Node head) {
		if (head == null) {
			return;
		}
		int level = 1;
		boolean lr = true;
		Node last = head;
		Node nlast = null;
		LinkedList<Node> dq = new LinkedList<>();
		dq.offer(head);
		printLevelAndOrientation(level++, lr);
		while (!dq.isEmpty()) {
			if (lr) {
				head = dq.pollFirst();
				if (head.left != null) {
					nlast = nlast == null ? head.left : nlast;
					dq.offerLast(head.left);
				}
				if (head.right != null) {
					nlast = nlast == null ? head.right : nlast;
					dq.offerLast(head.right);
				}
			} else {
				head = dq.pollLast();
				if (head.right != null) {
					nlast = nlast == null ? head.right : nlast;
					dq.offerFirst(head.right);
				}
				if (head.left != null) {
					nlast = nlast == null ? head.left : nlast;
					dq.offerFirst(head.left);
				}
			}
			System.out.print(head.value + " ");
			if (head == last && !dq.isEmpty()) {
				level++;
				last = nlast;
				nlast = null;
				lr = !lr;
				System.out.println();
				printLevelAndOrientation(level, lr);
			}
		}

	}

	public static void printLevelAndOrientation(int level, boolean lr) {
		System.out.print("Level " + level + " from ");
		System.out.print(lr ? "left to right : " : "right to left : ");
	}

	public static void main(String[] args) {
		Node head = P107.reconFromLevel("1!2!3!4!#!5!6!#!#!7!8!#!#!#!#!#!#!");
		printByLevel(head);
		zigzagPrint(head);
	}
}
