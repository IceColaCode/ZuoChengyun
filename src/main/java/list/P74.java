package list;


import java.util.Stack;

/**
 * @ClassName P74
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/11 17:32
 * @Version 1.0
 **/
public class P74 {
	public static Node partReverse(Node head, int k) {
		if (head == null || k < 2) return head;
		Node dummyHead = new Node(0);
		dummyHead.next = head;

		Node cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		int terms = len / k;

		Node left = dummyHead;
		Node nextLeft = null;
		Node pre = null;
		cur = head;
		Node next = null;

		for (int i = 0; i < terms; i++) {
			nextLeft = cur;
			for (int j = 0; j < k; j++) {
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			left.next = pre;
			left = nextLeft;
		}
		left.next = cur;
		return dummyHead.next;
	}

	public static Node partReverse2(Node head, int k) {
		if (head == null || k < 2) return head;
		Stack<Node> stack = new Stack<>();
		Node n1 = null;
		Node n2 = null;
		Node n3 = null;
		Node cur = head;

		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		int remain = stack.size() % k;
		while (remain-- != 0) {
			n3 = stack.pop();
		}

		while (!stack.isEmpty()) {
			n1 = stack.pop();
			n1.next = stack.isEmpty() ? null : stack.peek();
			for (int i = 1; i < k; i++) {
				n2 = stack.pop();
				n2.next = stack.isEmpty() ? null : stack.peek();
			}
			n2.next = n3;
			n3 = n1;
		}
		return n1;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		Node node = partReverse(node1, 3);
		System.out.println();
	}
}
