package Task_7.tree_set;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте TreeSet из 5 чисел и выведите его. Обратите внимание на порядок.
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(60);
        numbers.add(40);
        numbers.add(0);
        System.out.println(numbers);

//        Задача 2:
//        Напишите метод, который добавляет числа в TreeSet, но не позволяет добавить дубликаты.
        addNumsToTree(numbers, 10);
        addNumsToTree(numbers, 5);
        System.out.println(numbers);

//        Задача 3:
//        Найдите ближайшее большее и меньшее число к заданному в TreeSet.
        Integer num = 10;
        Integer higher = numbers.higher(num);
        Integer lower = numbers.lower(num);
        System.out.println(higher != null ? "ближайшее большее " + higher : "Нет большего");
        System.out.println(lower != null ? "ближайшее меньшее " + lower : "Нет меньшего");
    }

    public static void addNumsToTree(TreeSet<Integer> treeSet, Integer newNumber) {
        if (!treeSet.contains(newNumber)) {
            treeSet.add(newNumber);
            System.out.println("Число " + newNumber + " добавлено в множество");
        } else System.out.println("Число " + newNumber + " уже есть в множестве");
    }
}
