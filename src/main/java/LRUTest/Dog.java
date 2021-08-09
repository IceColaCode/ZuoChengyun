package LRUTest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author hylz
 * @Date 2020/3/9 9:43
 * @Version 1.0
 **/
public class Dog implements Serializable {
	private String name ;
	private String age ;
	private HashMap<String,String>[] pro;

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", pro=" + Arrays.toString(pro) +
				'}';
	}

	public Dog() {
	}

	public Dog(String name, String age, HashMap<String, String>[] pro) {
		this.name = name;
		this.age = age;
		this.pro = pro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public HashMap<String, String>[] getPro() {
		return pro;
	}

	public void setPro(HashMap<String, String>[] pro) {
		this.pro = pro;
	}

}
