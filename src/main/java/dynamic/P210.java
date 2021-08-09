package dynamic;

/**
 * @ClassName P210
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/22 18:02
 * @Version 1.0
 **/
public class P210 {
	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;

	}

	public static void main(String[] args) {
		int[] arr = new int[]{2,1,5,3,6,4,8,9,7};
		int[] dp = getdp2(arr);
		System.out.println();
	}
}
