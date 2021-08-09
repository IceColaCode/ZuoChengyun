package dynamic;

/**
 * @ClassName P199
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 22:34
 * @Version 1.0
 **/
public class P199 {
	public static int process(int[] arr, int aim, int index) {

		if (index == arr.length) {
			return aim == 0 ? 1 : 0;
		}
		int res = 0;
		for (int i = 0; arr[index] * i <= aim; i++) {
			res += process(arr,aim-arr[index]*i,index+1);
		}
		return res;

	}

	public static void main(String[] args) {
		int[] arr = {5, 10, 25, 1};
		int process = process(arr, 15,0);
		System.out.println(process);
	}
}
