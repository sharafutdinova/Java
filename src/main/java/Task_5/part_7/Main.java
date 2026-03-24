package Task_5.part_7;

public class Main {
    public static void main(String[] args) {
        AmusementPark park = new AmusementPark();
        Carousel carousel = new Carousel("Карусель");
        RollerCoasters rollerCoasters = new RollerCoasters("Американсикие горки");
        park.addAttraction(rollerCoasters);
        park.printAttractionDescription();
        park.manageAttraction();
    }
}
