package stack_queue;

import java.util.Queue;

/**
 * @ClassName P9
 * @Description TODO
 * @Author hylz
 * @Date 2020/4/6 16:41
 * @Version 1.0
 **/
public class P9 {
	public static void main(String[] args) {

	}
}





class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}

class Dog extends Pet {
	public Dog() {
		super("Dog");
	}
}

class Cat extends Pet {
	public Cat() {
		super("Cat");
	}
}
