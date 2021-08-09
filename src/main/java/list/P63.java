package list;

/**
 * @ClassName P63
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/11 15:48
 * @Version 1.0
 **/
class RNode {
	public int value;
	public RNode next;
	public RNode rand;

	public RNode(int value) {
		this.value = value;
	}
}

public class P63 {
	public static RNode copyRList(RNode head) {
		if (head==null){
			return null;
		}
		RNode cur = head;
		while (cur != null) {
			RNode node = new RNode(cur.value);
			node.next = cur.next;
			cur.next = node;
			cur = node.next;
		}
		cur = head;
		while (cur != null) {
			cur.next.rand = cur.rand == null ? null : cur.rand.next;
			cur = cur.next.next;
		}
		cur = head;
		RNode newHead = head.next;
		while (cur != null) {
			RNode next = cur.next;
			cur.next = next.next;
			next.next = next.next == null ? null : next.next.next;
			cur = cur.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		RNode node1 = new RNode(1);
		RNode node2 = new RNode(2);
		RNode node3 = new RNode(3);
		RNode node4 = new RNode(4);
		RNode node5 = new RNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.rand = node4;
		node2.rand = node3;
		node3.rand = node1;
		node4.rand = null;
		node5.rand = node2;
		RNode rNode = copyRList(node1);
		System.out.println(rNode);
	}
}
