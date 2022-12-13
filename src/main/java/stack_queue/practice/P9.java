package stack_queue.practice;

import java.util.HashMap;
import java.util.Queue;

public class P9 {

}

class DogCatQueue{

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