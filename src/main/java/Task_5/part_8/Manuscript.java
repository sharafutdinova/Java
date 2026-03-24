package Task_5.part_8;

public class Manuscript extends Exhibit {
    public Manuscript(String description) {
        super(description);
    }

    @Override
    public void preserve() {
        System.out.println("Манускрипт — требует контролируемой влажности");
    }
}
