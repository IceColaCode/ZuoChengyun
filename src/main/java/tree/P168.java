package tree;

/**
 * @ClassName P168
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/9 15:38
 * @Version 1.0
 **/
public class P168 {
	public static void main(String[] args) {

	}

	public static int getMaxdistance(Node head) {
		return process(head).maxDistance;
	}

	public static ReturnType168 process(Node head) {
		if (head == null) {
			return new ReturnType168(0, 0);
		}
		ReturnType168 left = process(head.left);
		ReturnType168 right = process(head.right);
		int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1);
		int height = Math.max(left.height, right.height) + 1;
		return new ReturnType168(maxDistance, height);

	}
}

class ReturnType168 {
	public int maxDistance;
	public int height;

	public ReturnType168(int maxDistance, int height) {
		this.maxDistance = maxDistance;
		this.height = height;
	}
}


