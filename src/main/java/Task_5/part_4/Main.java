package Task_5.part_4;

public class Main {
    public static void main(String[] args) {
//        Shark shark = new Shark();
        Starfish starfish = new Starfish();
        Aquarium aquarium = new Aquarium();
        aquarium.addSeaCreator(starfish);
        aquarium.showBehaviour();
    }
}
