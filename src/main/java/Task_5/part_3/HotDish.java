package Task_5.part_3;

public class HotDish extends Dish {
    private int temperature;

    public HotDish(String name, int temperature) {
        super(name);
        this.temperature = temperature;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("Температура блюда: " + this.temperature);
    }
}
