package bit_operation.practice;

/**
 * @ClassName P349
 * @Description TODO
 * @Author hylz
 * @Date 2021/7/7 17:16
 * @Version 1.0
 **/
public class P349 {

	public static int maxNum(int a, int b) {
		int c = a - b;
		int isNeg = (c >>> 31) & 1;
		return a * (isNeg ^ 1) + b * isNeg;
	}

	public static void main(String[] args) {
		int maxNum = maxNum(4324234, 1320);
		System.out.println(maxNum);
	}
}
