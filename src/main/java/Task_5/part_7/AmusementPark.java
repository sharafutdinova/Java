package Task_5.part_7;

public class AmusementPark {
    Attraction attraction;

    public void addAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public void manageAttraction() {
        this.attraction.maintain();
    }

    public void printAttractionDescription() {
        this.attraction.printDescription();
    }
}
