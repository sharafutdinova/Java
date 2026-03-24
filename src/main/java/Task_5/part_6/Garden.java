package Task_5.part_6;

public class Garden {
    private Careable plant;

    public void addPlant(Careable plant) {
        this.plant = plant;
    }

    public void provideCare() {
        plant.care();
    }
}
