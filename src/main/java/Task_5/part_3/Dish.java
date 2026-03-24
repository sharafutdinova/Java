package Task_5.part_3;

public class Dish {
    private String name;

    public Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printDescription() {
        System.out.println("Название блюда: " + this.name);
    }
}
