package tree;

/**
 * @ClassName P146
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/7 17:30
 * @Version 1.0
 **/
public class P146 {
	public static void main(String[] args) {

	}

	public static boolean isBalancedTree(Node head) {
		return process(head).isBalanced;
	}

	public static ReturnType146 process(Node head) {
		if (head == null) {
			return new ReturnType146(true, 0);
		}
		ReturnType146 lType = process(head.left);
		ReturnType146 rType = process(head.right);
		if (!lType.isBalanced || !rType.isBalanced || Math.abs(lType.height - rType.height) > 1) {
			new ReturnType146(false, Math.max(lType.height, rType.height) + 1);
		}
		return new ReturnType146(true, Math.max(lType.height, rType.height) + 1);

	}

}

class ReturnType146 {
	public boolean isBalanced;
	public int height;

	public ReturnType146(boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height;
	}
}
