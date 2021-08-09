package dynamic;

import java.util.ArrayList;

/**
 * @ClassName P199_2
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 22:55
 * @Version 1.0
 **/
public class P199_2 {
	public static int process(int[] arr, int aim) {
		int[] dp = new int[aim + 1];
		dp[0] = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 1; j <= aim; j++) {
				if (j-arr[i]>=0){
					dp[j] = dp[j-arr[i]]+dp[j];
				}
			}
		}
		return dp[aim];
	}

	public static void main(String[] args) {
		int[] arr = {5, 10, 25, 1};
		int process = process(arr, 15);
		System.out.println(process);
		ArrayList<Integer> integers = new ArrayList<>();
	}
}
