package Task_7.linked_hash_set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте LinkedHashSet и добавьте в него 5 строк. Проверьте порядок элементов при выводе.
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        lines.add("One");
        lines.add("Two");
        lines.add("Three");
        lines.add("Four");
        lines.add("Five");
        lines.forEach(System.out::println);

//        Задача 2:
//        Напишите метод, который добавляет элемент в LinkedHashSet, но не добавляет дубликаты.
        addUnique(lines, "One");
        addUnique(lines, "Six");
        lines.forEach(System.out::println);
    }

    public static void addUnique(LinkedHashSet<String> set, String newElement) {
        if (!set.contains(newElement)) {
            set.add(newElement);
            System.out.println("Элемент " + newElement + " добавлен");
        } else {
            System.out.println("Элемент " + newElement + " уже есть в множестве");
        }
    }
}
