package Task_5.part_2;

public class Cat implements Playable {
    @Override
    public void eat() {
        System.out.println("Кошка ест влажный корм");
    }

    @Override
    public void play() {
        System.out.println("Кошка играет");
    }
}
