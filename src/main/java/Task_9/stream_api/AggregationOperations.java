package Task_9.stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class AggregationOperations {
    static void main(String[] args) {
//        1. Поиск максимального элемента
//        Задача: Напишите программу, которая принимает список чисел и находит в нём самое большое число, используя Stream API.
        List<Integer> numbers = Arrays.asList(1, 5, 8, 12, 66, 82, 1);
        var max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Максимальное число: " + max.get());

//        2. Поиск минимального элемента
//        Задача: Напишите программу, которая принимает список чисел и находит в нем наименьшее число, используя Stream API.
        var min = numbers.stream().min(Comparator.naturalOrder());
        System.out.println("Минимальное число: " + min.get());

//        3. Сумма всех элементов списка
//        Задача: Напишите программу, которая принимает список чисел и вычисляет их сумму, используя Stream API.
        int sum = numbers.stream().mapToInt(n -> n).sum();
        System.out.println("Сумма чисел: " + sum);

//        4. Поиск первого элемента, начинающегося на "Б"
//        Задача: Напишите программу, которая принимает список строк и находит первую строку, начинающуюся на букву "Б", используя Stream API.
        List<String> lines = Arrays.asList("Аптека", "Булочка", "Лампа", "Букет", "Вода", "Лимон");
        try {
            String lineStartsWithB = lines.stream().filter(n -> n.startsWith("Б")).findFirst().get();
            System.out.println("Слово на Б: " + lineStartsWithB);
        } catch (NoSuchElementException e) {
            System.out.println("Нет слов начинающихся с буквы Б");
        }

//        5. Проверка наличия хотя бы одного элемента по условию
//        Задача: Напишите программу, которая проверяет, есть ли хотя бы один элемент в списке,
//        который удовлетворяет заданному условию (например, является чётным числом), используя Stream API.
        boolean isMultipleOfFive = numbers.stream().anyMatch(n -> n % 5 == 0);
        System.out.println("Проверка есть ли числа кратные 5: " + isMultipleOfFive);
    }
}
