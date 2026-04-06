package practice.queue_tasks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTask {
    static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();
        addToQueue(queue);
        addToQueue(deque);
        printQueue(queue);
        printDeqeue(deque);
    }

    public static void addToQueue(Queue<String> queue) {
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
    }

    //Вывод элементов очереди
    public static void printQueue(Queue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    //Вывод элементов стека
    public static void printDeqeue(Deque<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.pollLast());
        }
    }
}
