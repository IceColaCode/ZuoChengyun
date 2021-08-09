package tree;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Stack;

/**
 * @ClassName Test
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/17 11:24
 * @Version 1.0
 **/
public class Test {
	public static void preOrder(Node head) {
		if (head == null) return;
		System.out.println(head.value);
		preOrder(head.left);
		preOrder(head.right);
	}

	public static void preOrder2(Node head) {
		if (head == null) return;
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.value);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public static void inOrder(Node head) {
		if (head == null) return;
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				System.out.println(head.value);
				head = head.right;
			}
		}
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
		inOrder(node1);
	}
}
