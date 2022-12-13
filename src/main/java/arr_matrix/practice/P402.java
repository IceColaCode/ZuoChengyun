package arr_matrix.practice;

/**
 * @ClassName P402
 * @Description TODO
 * @Author hylz
 * @Date 2021/8/12 10:29
 * @Version 1.0
 **/
public class P402 {
	public static double maxMul(double[] arr) {

		double[] minArr = new double[arr.length];
		double[] maxArr = new double[arr.length];
		minArr[0] = arr[0];
		maxArr[0] = arr[0];
		double maxMul = arr[0];
		for (int i = 1; i < arr.length; i++) {
			minArr[i] = Math.min(minArr[i - 1] * arr[i], Math.min(maxArr[i - 1] * arr[i], arr[i]));
			maxArr[i] = Math.max(minArr[i - 1] * arr[i], Math.max(maxArr[i - 1] * arr[i], arr[i]));
			maxMul = Math.max(maxMul, maxArr[i]);
		}
		return maxMul;

	}
}
