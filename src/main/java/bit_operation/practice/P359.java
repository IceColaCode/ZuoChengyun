package bit_operation.practice;

/**
 * @ClassName P359
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/2 15:28
 * @Version 1.0
 **/
public class P359 {
	public static void main(String[] args) {
		int[] arr = {2,3,3,3,3,5,7,5,5,3,5,2,2,5,2,2};
		int res = onceNum(arr,5);
		System.out.println(res);
	}
	public static int onceNum(int[] arr, int k) {
		int[] sum = getKthSum(arr, k);
		int res = getNumFromKth(sum, k);
		return res;
	}

	public static int[] getKthSum(int[] arr, int k) {

		int[] sum = new int[32];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			for (int j = 0; j < 32; j++) {
				sum[j] = (sum[j] + num % k) % k;
				num = num / k;
			}
		}
		return sum;

	}

	public static int getNumFromKth(int[] num, int k) {
		int res = 0;
		for (int i=0;i<32;i++){
			res += num[i] * Math.pow(k,i);
		}
		return res;
	}



}
