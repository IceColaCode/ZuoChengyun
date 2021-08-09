package tree;

/**
 * @ClassName P153
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/8 17:01
 * @Version 1.0
 **/
public class P153 {
	public static void main(String[] args) {

	}

	public static Node2 getNextNode(Node2 node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			Node2 r = node.right;
			while (r.left != null) {
				r = r.left;
			}
			return r;
		}
		if (node.parent == null){
			return null;
		}
		if (node.parent.left == node){
			return node.parent;
		}

		Node2 n = node.parent;
		while (n.parent !=null && n.parent.right == n){
			n = n.parent;
		}
		return n.parent;


	}

}

class Node2{
	public int value;
	public Node2 left;
	public Node2 right;
	public Node2 parent;
	public Node2(int data){
		this.value = data;
	}

}
