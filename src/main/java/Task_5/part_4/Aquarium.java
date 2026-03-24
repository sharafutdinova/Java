package Task_5.part_4;

public class Aquarium {
    private Movable seaCreator;

    public Movable getSeaCreator() {
        return seaCreator;
    }

    public void addSeaCreator(Movable seaCreator) {
        this.seaCreator = seaCreator;
    }

    public void showBehaviour() {
        this.seaCreator.move();
    }
}
