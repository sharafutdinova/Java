package Task_5.part_8;

public class Museum {
    private Exhibit exhibit;

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    public void takeCareExhibit() {
        this.exhibit.preserve();
    }

    public void printExhibitDescription() {
        this.exhibit.printDescription();
    }
}
