package string.practice;

/**
 * @ClassName P290_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/31 9:43
 * @Version 1.0
 **/
public class P290_2 {
	public static int findValidBracket(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] chars = str.toCharArray();
		int[] dp = new int[chars.length];
		int max = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == ')'){
				if(i-dp[i-1]-1>-1 && chars[i-dp[i-1]-1] == '('){
					dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 > -1 ? dp[i-dp[i-1]-2] : 0);
					max = Math.max(max,dp[i]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int validBracket = findValidBracket(")()(()())");
		System.out.println(validBracket);
	}
}
