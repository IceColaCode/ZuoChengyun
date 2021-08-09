package tree;

import java.util.Stack;

/**
 * @ClassName P93
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/12 17:24
 * @Version 1.0
 **/
public class P93 {

	public static void preOrderRecur(Node head) {
		if (head == null) return;
		Stack<Node> stack = new Stack<>();
		Node node = head;
		stack.push(node);
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			System.out.println(pop.value);
			if (pop.right != null) {
				stack.push(pop.right);
			}
			if (pop.left != null) {
				stack.push(pop.left);
			}
		}
	}

//	public static void inOrderRecur(Node head) {
//		if (head == null) {
//			return;
//		}
//		Stack<Node> stack = new Stack<>();
//		while (!stack.isEmpty() || head != null) {
//			if (head != null) {
//				stack.push(head);
//				head = head.left;
//			} else {
//				head = stack.pop();
//				System.out.println(head.value);
//				head = head.right;
//			}
//		}
//	}

	public static void inOrderRecur(Node head) {
		if (head == null) return;
		Stack<Node> stack = new Stack<>();
		Node node = head;
		stack.push(node);
		while (node.left != null) {
			node = node.left;
			stack.push(node);
		}
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			System.out.println(pop.value);
			if (pop.right != null) {
				node = pop.right;
				stack.push(node);
				while (node.left != null) {
					node = node.left;
					stack.push(node);
				}
			}
		}

	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(head);
		while (!stack1.isEmpty()) {
			Node node = stack1.pop();
			stack2.push(node);
			if (node.left != null) {
				stack1.push(node.left);
			}
			if (node.right != null) {
				stack1.push(node.right);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().value);
		}
	}

	public static void posOrderRecur2(Node head) {
		if (head == null) return;
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node c = null;
		while (!stack.isEmpty()) {
			c = stack.peek();
			if (c.left != null && c.left != head && c.right != head) {
				stack.push(c.left);
			} else if (c.right != null && c.right != head) {
				stack.push(c.right);
			} else {
				System.out.println(stack.pop().value);
				head = c;
			}
		}
	}

	public static void preOrder(Node head) {
		if (head == null) return;
		System.out.println(head.value);
		preOrder(head.left);
		preOrder(head.right);
	}

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
//		preOrder(node1);
//		preOrderRecur(node1);
//		inOrderRecur(node1);
		posOrderRecur(node1);
//		posOrderRecur2(node1);

	}
}
