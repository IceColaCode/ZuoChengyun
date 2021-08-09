package list;

/**
 * @ClassName JosephusKill1
 * @Description TODO
 * @Author hylz
 * @Date 2020/2/921:10
 * @Version 1.0
 **/
public class JosephusKill1 {
	public static Node josephusKill1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if(++count == m){
				last.next = head.next;
				count = 0;
			}else{
				last = last.next;
			}
			head= last.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = head;

		Node resNode = josephusKill1(head, 3);
	}
}
