package Task_5.part_3;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Dish bread = new Dish("Bread");
        Drink juice = new Drink("Juice", 300);
        HotDish meat = new HotDish("Grill meat", 70);

        menu.addDish(bread);
        menu.addDish(juice);
        menu.addDish(meat);
        menu.showDescription();
    }
}
