package stack_queue;

import java.util.LinkedList;
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

class PetStamp {
	private Pet pet;
	private int count;

	public PetStamp(Pet pet, int count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;
	}

	public int getCount() {
		return this.count;
	}

	public String getPetType(){
		return this.pet.getPetType();
	}
}

class DogCatQueue {
	private Queue<PetStamp> dogQueue;
	private Queue<PetStamp> catQueue;
	private int count;

	public DogCatQueue() {
		this.dogQueue = new LinkedList<>();
		this.catQueue = new LinkedList<>();
		this.count = 0;
	}

	public void add(Pet pet){
		if (pet.getPetType().equals("Dog")){
			dogQueue.add(new PetStamp(pet, count++));
		} else if (pet.getPetType().equals("Cat")){
			catQueue.add(new PetStamp(pet, count++));
		} else {
			throw new RuntimeException("ERROR, not dog or cat");
		}
	}
	public Pet pollAll(){
		if (!dogQueue.isEmpty() && !catQueue.isEmpty()){
			if (dogQueue.peek().getCount() > catQueue.peek().getCount()){
				return catQueue.poll().getPet();
			} else {
				return dogQueue.poll().getPet();
			}
		}
		if (!dogQueue.isEmpty()){
			return dogQueue.poll().getPet();
		}
		if (!catQueue.isEmpty()){
			return catQueue.poll().getPet();
		}
		throw new RuntimeException("Queue is empty");
	}

	public Dog pollDog(){
		if (dogQueue.isEmpty()){
			throw new RuntimeException("dogQueue is empty");
		}
		return (Dog)dogQueue.poll().getPet();
	}
	public Cat pollCat(){
		if (catQueue.isEmpty()){
			throw new RuntimeException("catQueue is empty");
		}
		return (Cat)catQueue.poll().getPet();
	}
	public boolean isEmpty(){
		return dogQueue.isEmpty() && catQueue.isEmpty();
	}
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}
	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}






}