package classic;

import java.util.ArrayList;

/**
 * @ClassName KMP
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/21 8:38
 * @Version 1.0
 **/

// kmp关键：1.研究对象是模式串  2.最长公共前后缀

public class KMP {

	void getNext(String pattern, int next[]) {
		int j = 0;
		int k = -1;
		int len = pattern.length();
		next[0] = -1;

		while (j < len - 1) {
			if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
				next[++j] = ++k;
			} else {
				// 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
				// p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]
				k = next[k];
			}
		}

	}

	public int[] getNextArray(char[] ms){
		if (ms.length == 1){
			return new int[]{-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length){
			if (ms[pos-1]==ms[cn]){
				next[pos++] = ++cn;
			} else if (cn > 0){
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	int kmp(String s, String pattern) {
		int i = 0;
		int j = 0;
		int slen = s.length();
		int plen = pattern.length();


		int[] next = getNextArray(pattern.toCharArray());

		while (i < slen && j < plen) {

			if (s.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (next[j] == -1) {
					i++;
				} else {
					j = next[j];
				}

			}

		}
		return j==plen ? i -j : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP kmp = new KMP();
		String str = "ABCDABABCDABC";
		String pattern = "ABCDABC";
		System.out.println(kmp.kmp(str, pattern));

	}

}
