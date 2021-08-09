package string.practice;

/**
 * @ClassName P325
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/2 9:22
 * @Version 1.0
 **/
public class P325 {
	public static void main(String[] args) {
		int[] arr = {3,-28,-29,2};
		int xor = maxXor(arr);
		System.out.println(xor);
	}
	public static int maxXor(int[] arr) {
		int xorFromHead = 0;
		int maxXor = 0;
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xorFromHead ^= arr[i];
			maxXor = Math.max(maxXor, xorFromHead);
			xor = 0;
			for (int j = 0; j < i; j++) {
				xor ^= arr[j];
				maxXor = Math.max(maxXor, xorFromHead ^ xor);
			}
		}
		return maxXor;
	}
}
