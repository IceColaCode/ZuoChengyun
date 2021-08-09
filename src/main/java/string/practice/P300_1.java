package string.practice;

/**
 * @ClassName P300_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/31 17:32
 * @Version 1.0
 **/
public class P300_1 {
	public static void main(String[] args) {
		int value = maxUnique("abadbccdebe");
		System.out.println(value);
	}
	public static int maxUnique(String str){
		int max = 1;
		int[] map = new int[256];
		for (int i=0;i<256;i++){
			map[i] = -1;
		}
		char[] chars = str.toCharArray();
		int pre = 0;
		int[] dp = new int[chars.length];
		map[chars[0]] = 0;
		dp[0] = 1;
		for (int i=1;i<chars.length;i++){
			if (map[chars[i]] != -1){
				pre = Math.max(i-dp[i-1],map[chars[i]] + 1);
			} else {
				pre = i - dp[i-1];
			}
			dp[i] = i - pre + 1;
			max = Math.max(max,dp[i]);
			map[chars[i]] = i;
		}
		return max;
	}
}
