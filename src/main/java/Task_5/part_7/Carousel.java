package Task_5.part_7;

public class Carousel extends Attraction {
    public Carousel(String description){
        super(description);
    }

    @Override
    public void maintain() {
        System.out.println("техническое обслуживание");
    }
}
