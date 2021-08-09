package bit_operation.practice;

/**
 * @ClassName P350
 * @Description TODO
 * @Author hylz
 * @Date 2021/7/28 14:23
 * @Version 1.0
 **/
public class P350 {
	public static int bitAdd(int a, int b) {
		while (a != 0) {
			int tmp = a ^ b;
			a = (a & b) << 1;
			b = tmp;
		}
		return b;
	}

	public static int bitMinus(int a, int b) {
		int c = bitAdd(~b, 1);
		return bitAdd(a, c);
	}

	public static boolean isNeg(int a) {
		return ((a >> 31) & 1) == 1;
	}

	public static int bitMul(int a, int b) {
//		boolean isNeg = isNeg(a) ^ isNeg(b);
//		if (isNeg(a)) {
//			a = ~bitMinus(a, 1);
//		}
//		if (isNeg(b)) {
//			b = ~bitMinus(b, 1);
//		}
		int mul = 0;
		while (b != 0) {
			if ((b & 1) == 1) {
				mul = bitAdd(mul, a);
			}
			a <<= 1;
			b >>>= 1;
		}
//		return isNeg ? -mul : mul;
		return mul;
	}

	public static int bitDiv(int a, int b) {
		int c;
		int tmp;
		int sum = 0;
		while (a >= b) {
			tmp = b;
			c = 1;
			while ((a >> 1) > tmp) {
				tmp = tmp << 1;
				c = c << 1;
			}
			sum = bitAdd(sum, c);
			a = bitMinus(a, tmp);
		}
		return sum;
	}

	public static void main(String[] args) {
		int i = bitAdd(8, 19);
		int c = bitMinus(19, 8);
		int mul = bitMul(13, -7);
		int div = bitDiv(65, 7);
		System.out.println(div);
	}
}
