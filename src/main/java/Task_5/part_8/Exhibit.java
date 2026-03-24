package Task_5.part_8;

public abstract class Exhibit {
    private String description;

    public Exhibit(String description) {
        this.description = description;
    }

    public abstract void preserve();

    public void printDescription() {
        System.out.println("Описание экспоната: " + description);
    }
}
