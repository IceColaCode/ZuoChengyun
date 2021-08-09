package dynamic;

/**
 * @ClassName P189
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 20:44
 * @Version 1.0
 **/
public class P189 {
	public static int process(int[] arr, int aim) {
		return process(arr, aim, 0);
	}

	public static int process(int[] arr, int aim, int index) {

		if (index == arr.length) {
			return aim == 0 ? 0 : -1;
		}

		int min = -1;
		for (int i = 0; aim - arr[index] * i >= 0; i++) {
			int next = process(arr, aim - arr[index] * i, index + 1);
			if (next != -1) {
				min = min == -1 ? next + i : Math.min(min, next + i);
			}
		}
		return min;

	}

	public static void main(String[] args) {
		int[] arr = {5,3,2};
		int process = process(arr, 27);
		System.out.println(process);
	}
}
