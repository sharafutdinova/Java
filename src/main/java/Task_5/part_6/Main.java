package Task_5.part_6;

public class Main {
    public static void main(String[] args) {
        Garden garden = new Garden();
        Careable cactus = new Cactus();
        Careable orhid = new Orhid();
        garden.addPlant(orhid);
        garden.provideCare();
    }
}
