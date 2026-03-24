package Task_5.part_2;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner();
        Cat cat = new Cat();
        Dog dog = new Dog();
        owner.addAnimal(dog);
        owner.playAnimal();
        owner.feedAnimal();
    }
}
