package Task_5.part_1;

public class Zoo {
    private Animal animal;

    public void showAnimalBehaiviour() {
        this.animal.move();
        this.animal.sound();
    }

    public void addAnimal(Animal animal) {
        this.animal = animal;
    }
}
