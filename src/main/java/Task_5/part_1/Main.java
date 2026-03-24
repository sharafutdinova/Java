package Task_5.part_1;

public class Main {
    public static void main(String[] args) {
        Animal bird = new Bird();
        Animal elephant = new Elephant();
        Zoo zoo_1 = new Zoo();
        Zoo zoo_2 = new Zoo();
        zoo_1.addAnimal(bird);
        zoo_1.showAnimalBehaiviour();
        zoo_2.addAnimal(elephant);
        zoo_2.showAnimalBehaiviour();
    }
}
