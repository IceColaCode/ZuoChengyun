package bit_operation.practice;

/**
 * @ClassName P355
 * @Description TODO
 * @Author hylz
 * @Date 2021/7/28 16:50
 * @Version 1.0
 **/
public class P355 {
	public static int count1(int n) {
		int res = 0;
		while (n != 0) {
			n = n & (n-1);
			res ++ ;
		}
		return res;
	}
}
