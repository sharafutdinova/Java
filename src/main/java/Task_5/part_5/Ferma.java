package Task_5.part_5;

public class Ferma {
    Producable animal;

    public void setAnimal(Producable animal) {
        this.animal = animal;
    }

    public void feedAnimal() {
        animal.feed();
    }

    public void getProducts() {
        animal.produce();
    }
}
