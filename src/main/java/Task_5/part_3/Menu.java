package Task_5.part_3;

import java.util.ArrayList;

public class Menu {
    ArrayList<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void showDescription() {
        int length = dishes.size();
        for (int i = 0; i < length; i++) {
            dishes.get(i).printDescription();
        }
    }
}
