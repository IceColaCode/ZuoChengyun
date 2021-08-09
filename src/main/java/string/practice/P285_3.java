package string.practice;

/**
 * @ClassName P285_3
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/28 17:52
 * @Version 1.0
 **/
public class P285_3 {
	public static void main(String[] args) {
		String res = getPalindrome("A1BC22DE1F", "1221");
		System.out.println(res);
	}

	public static String getPalindrome(String str, String strlps) {
		char[] c = str.toCharArray();
		char[] clps = strlps.toCharArray();
		char[] res = new char[c.length * 2 - clps.length];
		int cl = 0;
		int cr = c.length - 1;
		int clpsl = 0;
		int clpsr = clps.length - 1;
		int resl = 0;
		int resr = res.length - 1;
		int tmpl = 0;
		int tmpr = cr;
		while (resl <= resr) {
			tmpl = cl;
			tmpr = cr;
			while (c[cl] != clps[clpsl]) {
				cl++;
			}
			while (c[cr] != clps[clpsr]) {
				cr--;
			}

			for (int i = tmpl; i < cl; i++) {
				res[resl++] = c[i];
				res[resr--] = c[i];
			}
			for (int j = tmpr; j > cr; j--) {
				res[resl++] = c[j];
				res[resr--] = c[j];
			}

			res[resl++] = c[cl++];
			res[resr--] = c[cr--];
			clpsl++;
			clpsr--;
		}
		return String.valueOf(res);
	}


}
