package string.practice;

/**
 * @ClassName P290_1
 * @Description TODO
 * @Author hylz
 * @Date 2021/5/31 9:34
 * @Version 1.0
 **/
public class P290_1 {
	public static void main(String[] args) {

	}
	public static boolean isValid(String str){
		int cnt = 0;
		if (str == null ||str.length() == 0){
			return false;
		}
		char[] chars = str.toCharArray();
		for (int i=0;i<chars.length;i++){
			if (chars[i] == '('){
				cnt++;
			} else if (chars[i] == ')'){
				if (cnt-- < 1){
					return false;
				}
			} else {
				return false;
			}
		}
		return cnt == 0;

	}
}
