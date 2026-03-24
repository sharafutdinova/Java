package Task_5.part_8;

public class Sculpture extends Exhibit {
    public Sculpture(String description){
        super(description);
    }
    @Override
    public void preserve() {
        System.out.println("Скульптура — нуждается в реставрации");
    }
}
