package Task_5.part_3;

public class Drink extends Dish {
    private int volume;

    public Drink(String name, int volume) {
        super(name);
        this.volume = volume;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("Объем напитка: " + this.volume);
    }
}
