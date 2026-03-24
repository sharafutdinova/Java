package practice_5.task_2;

public class Manager {
    public void manage(Item item) {
        item.print();
    }

    public void changeCount(Item item, int newCount) {
        item.setCount(newCount);
    }
}
