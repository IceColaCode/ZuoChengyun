package dynamic;

/**
 * @ClassName P192
 * @Description TODO
 * @Author hylz
 * @Date 2020/5/5 22:08
 * @Version 1.0
 **/
public class P192 {
	public static int process(int total,int cur,int rest,int des){

		if (rest == 0){
			return cur == des ? 1 : 0;
		}
		if (cur == 1){
			return process(total,2,rest-1,des);
		} else if (cur==total){
			return process(total,total-1,rest-1,des);
		} else {
			return process(total,cur-1,rest-1,des) + process(total,cur+1,rest-1,des);
		}
	}

	public static void main(String[] args) {
		int process = process(5, 2, 3, 3);
		System.out.println(process);
	}
}
