package Task_7.array_deque;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте ArrayDeque, добавьте 5 элементов и выведите их.
        ArrayDeque<String> elements = new ArrayDeque<>();
        elements.add("One 1");
        elements.add("Two 2");
        elements.add("Three 3");
        elements.add("Four 4");
        elements.add("Five 5");
        elements.forEach(System.out::println);
//
//        Задача 2:
//        Используйте ArrayDeque как стек: добавьте элементы и извлеките их в обратном порядке.
        System.out.println("Task 2");
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.push("Five");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
//
//        Задача 3:
//        Используйте ArrayDeque как очередь: добавьте элементы в начало и конец, извлеките из обоих концов.
        System.out.println("Task 3");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(1);
        queue.addLast(10);
        queue.addFirst(2);
        queue.addLast(9);
        System.out.println(queue);
        System.out.println("First " + queue.getFirst());
        System.out.println("Last " + queue.getLast());
    }
}
