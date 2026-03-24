package Task_5.part_8;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum();
        Sculpture sculpture = new Sculpture("Скульптура 18 века");
        Manuscript manuscript = new Manuscript("Древний манускрипт");
        museum.setExhibit(manuscript);
        museum.printExhibitDescription();
        museum.takeCareExhibit();
    }
}
