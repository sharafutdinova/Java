package Task_5.part_7;

public abstract class Attraction {

    private String description;

    public abstract void maintain();

    public Attraction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void printDescription() {
        System.out.println("Описание аттракциона " + description);
    }
}
