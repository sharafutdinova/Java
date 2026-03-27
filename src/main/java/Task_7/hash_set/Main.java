package Task_7.hash_set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте HashSet из 5 чисел и выведите его содержимое.
        Set<Integer> numbers_1 = new HashSet<>();
        numbers_1.add(1);
        numbers_1.add(2);
        numbers_1.add(3);
        numbers_1.add(4);
        numbers_1.add(5);
        System.out.println(numbers_1);

//        Задача 2:
//        Добавьте в HashSet 10 чисел. Проверьте, содержит ли он заданное число.
        Set<Integer> numbers_2 = new HashSet<>();
        numbers_2.add(1);
        numbers_2.add(2);
        numbers_2.add(3);
        numbers_2.add(4);
        numbers_2.add(5);
        numbers_2.add(6);
        numbers_2.add(7);
        numbers_2.add(8);
        numbers_2.add(9);
        numbers_2.add(10);
        System.out.println(numbers_2.contains(7) ? "Число содержится в hashSet" : "Число не содержится в hashSet");
        System.out.println(numbers_2.contains(11) ? "Число содержится в hashSet" : "Число не содержится в hashSet");

//        Задача 3:
//        Реализуйте метод, который принимает List<String> и возвращает Set<String> без дубликатов.
        List<String> lines = new ArrayList<>(Arrays.asList("1", "2", "4", "1", "5", "2"));
        Set<String> uniqueLines = getSet(lines);
        System.out.println(uniqueLines);

//        Задача 4:
//        Создайте HashSet, содержащий набор имен. Напишите программу, которая проверяет, содержится ли ваше имя в множестве, и выводит соответствующее сообщение.
        Set<String> names = new HashSet<>(List.of("Alsu", "Sasha", "Anna", "Alex"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println(names.contains(name) ? "Имя содержится в множестве" : "Имя не содержится в множестве");
    }

    public static HashSet<String> getSet(List<String> list) {
        return new HashSet<String>(list);
    }
}
