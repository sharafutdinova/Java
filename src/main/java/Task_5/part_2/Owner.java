package Task_5.part_2;

import Task_5.part_1.Animal;

public class Owner {
    public Playable animal;

    public void addAnimal(Playable animal) {
        this.animal = animal;
    }

    public void feedAnimal() {
        this.animal.eat();
    }

    public void playAnimal() {
        this.animal.play();
    }
}
