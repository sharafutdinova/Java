package Task_5.part_2;

public class Dog implements Playable {
    @Override
    public void eat() {
        System.out.println("Собака ест сухой корм");
    }

    @Override
    public void play() {
        System.out.println("Собака гуляет");
    }
}
