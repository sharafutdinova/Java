package Task_5.part_1;

public class Bird extends Animal {
    @Override
    public void sound() {
        System.out.println("Птица чирикает");
    }

    @Override
    public void move() {
        System.out.println("Птица летает");
    }
}
