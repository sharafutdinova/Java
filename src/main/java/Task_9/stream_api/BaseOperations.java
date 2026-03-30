package Task_9.stream_api;

import java.util.Arrays;
import java.util.List;

public class BaseOperations {
    static void main(String[] args) {
//        1. Фильтрация строк по длине больше 5
//        Задача: Напишите программу, которая принимает список строк и удаляет из него все строки длиной 5 символов и менее, используя Stream API.
        List<String> list = Arrays.asList("One", "Photo", "Potato", "Windows", "Apple", "Photo", "Potato" );
        List<String> filteredList = list.stream()
                .filter(element -> element.length() > 5)
                .toList();
        System.out.println("Строки длиной более 5: " + filteredList);

//        2. Фильтрация чисел, кратных 5
//        Задача: Напишите программу, которая принимает список чисел и отбирает только те, которые делятся на 5 без остатка, используя Stream API.
        List<Integer> numbers = Arrays.asList(1, 4, 5, 10, 15, 49);
        List<Integer> filteredNumbers = numbers.stream()
                .filter(element -> element % 5 == 0)
                .toList();
        System.out.println("Числа кратные 5: " + filteredNumbers);

//        3. Преобразование строк в их длины
//        Задача: Напишите программу, которая принимает список строк и заменяет каждую строку на её длину, используя Stream API.
        List<Integer> lengths = list.stream()
                .map(String::length)
                .toList();
        System.out.println("Длины строк : " + lengths);

//        4. Создание списка квадратов чисел
//        Задача: Напишите программу, которая принимает список чисел и преобразует его в новый список, где каждое число заменено на его квадрат, используя Stream API.
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .toList();
        System.out.println("Квадраты числел : " + squares);

//        5. Удаление дубликатов из списка
//        Задача: Напишите программу, которая принимает список элементов и удаляет из него все дубликаты, используя Stream API.
        List<String> uniqueLines = list.stream()
                .distinct()
                .toList();
        System.out.println("Уникальные строки : " + uniqueLines);
    }
}
