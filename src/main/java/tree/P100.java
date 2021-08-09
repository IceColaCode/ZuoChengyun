package tree;

/**
 * @ClassName P100
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/12 19:00
 * @Version 1.0
 **/
public class P100 {
	public static int height = 0;

	public static void printEdge1(Node head) {
		if (head == null) return;
		height = getHeight(head);
		Node[][] nodes = new Node[height][2];
		getEdge(head, 0, nodes);
		for (int i = 0; i < nodes.length; i++) {
			System.out.println(nodes[i][0].value);
		}
		printLeafNodes(head, 0, nodes);
		for (int i = nodes.length - 1; i >= 0; i--) {
			if (nodes[i][0] != nodes[i][1]) {
				System.out.println(nodes[i][1].value);
			}
		}

	}

	public static int getHeight(Node head) {
		if (head == null) return 0;
		return Math.max(getHeight(head.left), getHeight(head.right)) + 1;
	}

	public static void getEdge(Node head, int l, Node[][] nodes) {
		if (head == null) return;
		nodes[l][0] = nodes[l][0] == null ? head : nodes[l][0];
		nodes[l][1] = head;
		getEdge(head.left, l + 1, nodes);
		getEdge(head.right, l + 1, nodes);
	}

	public static void printLeafNodes(Node head, int l, Node[][] nodes) {
		if (head == null) return;
		if (head.left == null && head.right == null && head != nodes[l][0] && head != nodes[l][1]) {
			System.out.println(head.value);
		}
		printLeafNodes(head.left, l + 1, nodes);
		printLeafNodes(head.right, l + 1, nodes);
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
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node5.left = node9;
		node5.right = node10;
		node8.right = node11;
		node9.left = node12;
		node11.left = node13;
		node11.right = node14;
		node12.left = node15;
		node12.right = node16;
		printEdge1(node1);

	}
}
