package bit_operation.practice;

/**
 * @ClassName P357
 * @Description TODO
 * @Author hylz
 * @Date 2021/7/28 17:41
 * @Version 1.0
 **/
public class P357 {
	public static void printOddNum(int[] arr) {
		int eor = arr[0];
		for (int i = 1; i < arr.length; i++) {
			eor ^= arr[i];
		}
		int a = eor & (~eor + 1);
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & a) == 1) {
				num1 ^= arr[i];
			} else {
				num2 ^= arr[i];
			}
		}
		System.out.println(num1);
		System.out.println(num2);
	}

	public static void main(String[] args) {
		printOddNum(new int[]{4,5,6,2,9,8,6,9,4,2});
	}
}
