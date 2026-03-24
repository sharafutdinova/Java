package Task_5.part_5;

public class Main {
    public static void main(String[] args) {
        Ferma ferma = new Ferma();
        Chicken chicken = new Chicken();
        Cow cow = new Cow();
        ferma.setAnimal(cow);
        ferma.feedAnimal();
        ferma.getProducts();
    }
}
