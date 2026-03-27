package Task_7.linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте LinkedList и добавьте в него 5 строк. Выведите все элементы списка.
        List<String> lines = new LinkedList<>();
        lines.add("One");
        lines.add("Two");
        lines.add("Three");
        lines.add("Four");
        lines.add("Five");
        lines.forEach(System.out::println);

//        Задача 2:
//        Реализуйте очередь задач с LinkedList. Добавьте 3 задачи и обработайте их в порядке поступления.
        List<String> queue = new LinkedList<>();
        queue.add("Shopping");
        queue.add("Gym");
        queue.add("Washing");
        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }

//        Задача 3:
//        Создайте LinkedList, содержащий несколько строк. Напишите программу, которая печатает первый и последний элементы списка.
        List<String> list = new LinkedList<>(List.of("First", "Middle_1", "Middle_2", "Last"));
        System.out.println("First " + list.getFirst());
        System.out.println("Last " + list.getLast());

//        Задача 4:
//        Создайте LinkedList из целых чисел. Напишите программу, которая вычисляет сумму элементов списка.
        LinkedList<Integer> numbers = new LinkedList<>(List.of(1, 5, 7, 81, 23));
        Integer sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        System.out.println("Сумма = " + sum);

//        Задача 5:
//        Используйте ListIterator для прохода по LinkedList в обоих направлениях.
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
