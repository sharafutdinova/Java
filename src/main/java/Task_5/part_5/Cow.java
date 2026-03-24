package Task_5.part_5;

public class Cow implements Producable {
    @Override
    public void produce() {
        System.out.println("Корова даёт молоко");
    }

    @Override
    public void feed() {
        System.out.println("Корова нуждается в выпасе");
    }
}
