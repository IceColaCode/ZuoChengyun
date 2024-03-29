package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Node
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/12 17:24
 * @Version 1.0
 **/
public class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int data) {
		this.value = data;
	}

	public static int getTreeDepth(Node root) {
		return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
	}


	private static void writeArray(Node currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
		// 保证输入的树不为空
		if (currNode == null) return;
		// 先将当前节点保存到二维数组中
		res[rowIndex][columnIndex] = String.valueOf(currNode.value);

		// 计算当前位于树的第几层
		int currLevel = ((rowIndex + 1) / 2);
		// 若到了最后一层，则返回
		if (currLevel == treeDepth) return;
		// 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
		int gap = treeDepth - currLevel - 1;

		// 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
		if (currNode.left != null) {
			res[rowIndex + 1][columnIndex - gap] = "/";
			writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
		}

		// 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
		if (currNode.right != null) {
			res[rowIndex + 1][columnIndex + gap] = "\\";
			writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
		}
	}


	public static void show(Node root) {
		if (root == null) System.out.println("EMPTY!");
		// 得到树的深度
		int treeDepth = getTreeDepth(root);

		// 最后一行的宽度为2的（n - 1）次方乘3，再加1
		// 作为整个二维数组的宽度
		int arrayHeight = treeDepth * 2 - 1;
		int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
		// 用一个字符串数组来存储每个位置应显示的元素
		String[][] res = new String[arrayHeight][arrayWidth];
		// 对数组进行初始化，默认为一个空格
		for (int i = 0; i < arrayHeight; i ++) {
			for (int j = 0; j < arrayWidth; j ++) {
				res[i][j] = " ";
			}
		}

		// 从根节点开始，递归处理整个树
		// res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
		writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

		// 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
		for (String[] line: res) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < line.length; i ++) {
				sb.append(line[i]);
				if (line[i].length() > 1 && i <= line.length - 1) {
					i += line[i].length() > 4 ? 2: line[i].length() - 1;
				}
			}
			System.out.println(sb.toString());
		}
	}

	public static Node constructTree(Integer[] nums){
		if (nums.length == 0) return new Node(0);
		Deque<Node> nodeQueue = new LinkedList<>();
		// 创建一个根节点
		Node root = new Node(nums[0]);
		nodeQueue.offer(root);
		Node cur;
		// 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
		int lineNodeNum = 2;
		// 记录当前行中数字在数组中的开始位置
		int startIndex = 1;
		// 记录数组中剩余的元素的数量
		int restLength = nums.length - 1;

		while(restLength > 0) {
			// 只有最后一行可以不满，其余行必须是满的
//            // 若输入的数组的数量是错误的，直接跳出程序
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new Node(0);
//            }
			for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
				// 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i == nums.length) return root;
				cur = nodeQueue.poll();
				if (nums[i] != null) {
					cur.left = new Node(nums[i]);
					nodeQueue.offer(cur.left);
				}
				// 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i + 1 == nums.length) return root;
				if (nums[i + 1] != null) {
					cur.right = new Node(nums[i + 1]);
					nodeQueue.offer(cur.right);
				}
			}
			startIndex += lineNodeNum;
			restLength -= lineNodeNum;
			lineNodeNum = nodeQueue.size() * 2;
		}

		return root;
	}

	public static void main(String[] args) {
		Node root = constructTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});
		show(root);

		Node root2 = constructTree(new Integer[]{1,2,3,null,4,5,6});
		show(root2);


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
		show(node1);
	}
}
