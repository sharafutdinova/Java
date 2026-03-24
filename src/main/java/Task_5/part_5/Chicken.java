package Task_5.part_5;

public class Chicken implements Producable {
    @Override
    public void produce() {
        System.out.println("Курица дает яйца");
    }

    @Override
    public void feed() {
        System.out.println("Курица требует зерно");
    }
}
