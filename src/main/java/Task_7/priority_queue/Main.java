package Task_7.priority_queue;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте PriorityQueue и добавьте 5 чисел. Выведите их в порядке удаления.
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(2);
        numbers.add(90);
        numbers.add(122);
        numbers.add(45);
        numbers.add(73);
        while(!numbers.isEmpty()){
            System.out.println(numbers.poll());
        }
    }
}
