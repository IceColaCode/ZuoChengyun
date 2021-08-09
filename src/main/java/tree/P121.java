package tree;

/**
 * @ClassName P121
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/2 15:30
 * @Version 1.0
 **/
public class P121 {
	public static void main(String[] args) {
		Node head = P107.reconFromLevel("6!1!12!0!3!10!13!#!#!#!#!4!14!20!16!2!5!11!15!#!#!#!#!#!#!#!#!#!#!#!#!");
		Node maxBST = getMaxBST(head);
		System.out.println();
	}

	public static Node getMaxBST(Node head) {
		return process(head).maxBSTHead;
	}

	public static ReturnType process(Node X) {
		if (X == null) {
			return new ReturnType(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		ReturnType lData = process(X.left);
		ReturnType rData = process(X.right);

		int min = Math.min(X.value, Math.min(lData.min, rData.min));
		int max = Math.max(X.value, Math.max(lData.max, rData.max));
		int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
		Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;

		if (X.value > lData.max && X.value < rData.min &&
				X.left == lData.maxBSTHead && X.right == rData.maxBSTHead) {
			maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
			maxBSTHead = X;
		}

		return new ReturnType(maxBSTHead, maxBSTSize, max, min);

	}

}

class ReturnType {
	public Node maxBSTHead;
	public int maxBSTSize;
	public int max;
	public int min;

	public ReturnType(Node maxBSTHead, int maxBSTSize, int max, int min) {
		this.maxBSTHead = maxBSTHead;
		this.maxBSTSize = maxBSTSize;
		this.max = max;
		this.min = min;
	}

}
