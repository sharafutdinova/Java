package Task_9.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingOperations {
    static void main(String[] args) {
//        1. Группировка строк по первой букве
//        Задача: Напишите программу, которая принимает список строк и группирует их по первой букве, используя Stream API.
        List<String> lines = Arrays.asList("Аптека", "Булочка", "Лампа", "Букет", "Вода", "Лимон");
        Map<Character, List<String>> groupedByFirstChar = lines.stream().collect(Collectors.groupingBy(line -> line.charAt(0)));
        System.out.println("Группировка по первому символу: " + groupedByFirstChar);

//        2. Группировка чисел по чётности
//        Задача: Напишите программу, которая принимает список чисел и группирует их на чётные и нечётные, используя Stream API.
        List<Integer> numbers = Arrays.asList(1, 5, 8, 12, 66, 82, 1);
        Map<Boolean, List<Integer>> groupedByParity = numbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("Группировка по четности: " + groupedByParity);

//        3. Поиск среднего значения чисел
//        Задача: Напишите программу, которая принимает список чисел и находит их среднее значение, используя Stream API.
        double average = numbers.stream().collect(Collectors.averagingInt(n -> n));
        System.out.println("Среднее значение: " + average);
    }
}
