package tree;

/**
 * @ClassName P155
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/9 14:53
 * @Version 1.0
 **/
public class P155 {
	public static void main(String[] args) {

	}

	public static Node lowestAncestor(Node head,Node o1,Node o2){
		if (head == null || head == o1 || head == o2){
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if (left == null && right == null){
			return null;
		}
		if (left == null){
			return right;
		}
		if (right == null){
			return left;
		}
		return head;
	}
}
