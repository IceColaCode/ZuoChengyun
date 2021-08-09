package dynamic.practice;

/**
 * @ClassName P199_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/2/25 17:58
 * @Version 1.0
 **/
public class P199_2 {
	public static void main(String[] args) {
		int[] arr = {5, 10, 25, 1};
		int process = process(arr, 0, 15);
		System.out.println(process);
	}

	public static int process(int[] arr, int index, int aim) {
		if (index == arr.length) {
			return aim == 0 ? 1 : 0;
		}
		int n = 0;
		int res = 0;
		while (arr[index] * n <= aim) {
			res += process(arr, index + 1, aim - arr[index] * n);
			n++;
		}
		return res;

	}

//	public static int process(int[] arr, int index, int aim) {
//		if (index == arr.length) {
//			return aim == 0 ? 1 : 0;
//		}
//		int n = 0;
//		int res = 0;
//		while (arr[index] * n <= aim) {
//			res += process(arr, index + 1, aim - arr[index] * n);
//			n++;
//		}
//		return res;
//	}

}
