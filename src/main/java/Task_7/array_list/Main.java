package Task_7.array_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте ArrayList из 5 чисел. Добавьте ещё одно число в конец. Выведите весь список.
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 5, 65, 89, 43));
        arrayList.add(100);
        arrayList.forEach(System.out::println);

//        Задача 2:
//        Напишите программу, которая выводит все чётные числа из ArrayList.
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 5, 65, 89, 43, 56, 12));
        numbers.forEach(num -> {
            if (num % 2 == 0) System.out.println(num);
        });

//        Задача 3:
//        Создайте ArrayList из строк. Найдите в нём самую длинную строку и выведите её.
        List<String> lines = new ArrayList<>(Arrays.asList("Word", "Name", "Family", "Automation", "Game"));
        String longestLine = "";
        for (String line : lines) {
            if (line.length() > longestLine.length())
                longestLine = line;
        }
        System.out.println("Самая длинная строка " + longestLine);

//        Задача 4:
//        Создайте ArrayList из целых чисел. Напишите программу, которая вычисляет и выводит сумму всех чисел в списке.
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        System.out.println("Сумма чисел массива " + sum);

//        5. ArrayList Задача 5:
//        Создайте ArrayList из целых чисел. Напишите программу, которая находит и выводит максимальное число из списка.
        int max = numbers.getFirst();
        for (Integer num : numbers) {
            if (num > max) max = num;
        }
        System.out.println("Максимум " + max);
    }
}
