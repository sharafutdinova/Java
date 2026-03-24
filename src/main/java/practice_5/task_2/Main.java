package practice_5.task_2;

import practice_5.task_1.*;

public class Main {
    public static void main(String[] args) {
        Item electronics = new Electronics("Phone", 1000, 12);
        Item jeans = new Clothes("Jeans", 100, 10);
        Item pen = new Item("Pen", 10, 100);
        Manager alsu = new Manager();
        alsu.changeCount(pen, 90);
        alsu.manage(pen);
        alsu.manage(jeans);
        alsu.manage(electronics);
    }
}
