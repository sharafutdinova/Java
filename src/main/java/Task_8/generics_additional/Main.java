package Task_8.generics_additional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//Обобщённый класс
//Задача: Создайте класс Storage<T>, который хранит элемент и возвращает его.
        Storage<Double> numStorage = new Storage<>();
        numStorage.setSomeValue(16.0);
        System.out.println("Task 1 " + numStorage.getSomeValue());

//Работа с числами
//Задача: Создайте класс NumberBox<T extends Number>, который хранит только числа и возвращает их сумму.
        NumberBox<Integer> numberBox = new NumberBox<>();
        numberBox.addNumber(12);
        numberBox.addNumber(5);
        numberBox.addNumber(3);
        System.out.println("Task 2 " + numberBox.getSum());

//
//Ограничение сверху
//Задача: Напишите обобщённый метод, который принимает List<T extends Number> и вычисляет сумму элементов.
        List<Integer> intList = new LinkedList<>();
        intList.add(12);
        intList.add(65);
        intList.add(9);
        System.out.println("Task 3 " + sum(intList));

// Ограничение снизу
//Задача: Реализуйте метод, который принимает List<T super Integer> и добавляет в него несколько чисел.
        List<Number> numberList = new LinkedList<>();
        addNumbers(numberList, 5);
        addNumbers(numberList, 9);
        System.out.println("Task 4 " + numberList);

//Обобщённый интерфейс
//Задача: Создайте интерфейс Container<T>, содержащий методы add(T item) и get().
        ContainterClass<String> containterClass = new ContainterClass();
        containterClass.add("Container");
        System.out.println("Task 5 " + containterClass.get());

//Коллекция с обобщёнными типами
//Задача: Создайте Map<K, V> и реализуйте метод, который принимает обобщённые ключи и значения, а затем выводит их.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println("Task 6");
        printMap(map);
    }

    public static <T> Double sum(List<? extends Number> list) {
        Double sum = 0.0;
        for (Number num : list) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }

    public static <T> void addNumbers(List<? super Integer> list, Integer num) {
        list.add(num);
    }

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey().toString() + " value: " + entry.getValue().toString());
        }
    }
}


