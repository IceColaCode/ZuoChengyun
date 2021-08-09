package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName P107
 * @Description TODO
 * @Author hylz
 * @Date 2021/1/28 17:17
 * @Version 1.0
 **/
public class P107 {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		String s = serialByLevel(node1);
		System.out.println(s);
//		StringBuilder sb = new StringBuilder();
//		serialByPre(node1, sb);
//		System.out.println(sb.toString());
	}

	public static void serialByPre(Node head, StringBuilder sb) {
		if (head == null) {
			sb.append("#!");
			return;
		}
		sb.append(head.value).append("!");
		serialByPre(head.left, sb);
		serialByPre(head.right, sb);
	}

	public static Node deserialByPre(String str, int index) {
		String[] arr = str.split("!");
		Queue<String> queue = new LinkedList<>();
		for (String string : arr) {
			queue.add(string);
		}
		return reconPreOrder(queue);
	}

	public static Node reconPreOrder(Queue<String> queue) {
		String poll = queue.poll();
		if ("#".equals(poll)) {
			return null;
		}
		Node node = new Node(Integer.valueOf(poll));
		node.left = reconPreOrder(queue);
		node.right = reconPreOrder(queue);
		return node;
	}

	public static String serialByLevel(Node head) {
		if (head == null) return "#!";
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			if (poll == null) {
				sb.append("#!");
			} else {
				sb.append(poll.value).append("!");
				queue.offer(poll.left);
				queue.offer(poll.right);
			}
		}
		return sb.toString();
	}

	public static Node reconFromLevel(String string) {
		String[] split = string.split("!");
		int index = 0;
		Queue<Node> queue = new LinkedList<>();
		Node head = generateNode(split[index++]);
		queue.offer(head);
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			poll.left = generateNode(split[index++]);
			poll.right = generateNode(split[index++]);
			if (poll.left!=null){
				queue.offer(poll.left);
			}
			if (poll.right!=null){
				queue.offer(poll.right);
			}
		}
		return head;

	}

	public static Node generateNode(String str) {
		if ("#".equals(str)) {
			return null;
		}
		return new Node(Integer.valueOf(str));
	}

}
