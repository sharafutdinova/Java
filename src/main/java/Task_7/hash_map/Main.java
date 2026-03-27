package Task_7.hash_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте HashMap<String, Integer>, добавьте 5 пар (имя – возраст) и выведите все записи.
        HashMap<String, Integer> persons = new HashMap<>();
        persons.put("Alsu", 30);
        persons.put("Mary", 7);
        persons.put("Anna", 25);
        persons.put("Kate", 45);
        persons.put("Alla", 11);
        persons.forEach((key, value) -> {
            System.out.println("Name is " + key + ", age " + value);
        });

//        Задача 2:
//        Проверьте, есть ли определённое имя в HashMap.
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        System.out.println(persons.containsKey(name) ? "Найдено, возраст " + persons.get(name) : "Не найдено");

//        Задача 3:
//        Реализуйте метод, который печатает из HashMap всех пользователей младше 18 лет.
        printUnderage(persons);
    }

    public static void printUnderage(HashMap<String, Integer> persons) {
        for (Map.Entry<String, Integer> entry : persons.entrySet()) {
            if (entry.getValue() < 18)
                System.out.println("Name is " + entry.getKey() + ", age " + entry.getValue());
        }
    }
}
