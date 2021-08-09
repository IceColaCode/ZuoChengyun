package dynamic.practice;

/**
 * @ClassName P217_2
 * @Description TODO
 * @Author hylz
 * @Date 2021/3/1 9:20
 * @Version 1.0
 **/
public class P217_2 {
	public static void main(String[] args) {
		printHano(3);
	}

	public static void printHano(int n) {
		process(n,"left","mid","right");
	}

	public static void process(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println(String.format("move from %s to %s", from, to));
			return;
		}
		process(n - 1, from, to, mid);
		System.out.println(String.format("move from %s to %s", from, to));
		process(n - 1, mid, from, to);

	}
}
