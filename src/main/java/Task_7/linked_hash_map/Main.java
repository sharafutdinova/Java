package Task_7.linked_hash_map;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте LinkedHashMap и добавьте в него 5 элементов. Выведите их в порядке добавления.
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Element 1", 1);
        map.put("Element 2", 2);
        map.put("Element 3", 3);
        map.put("Element 4", 4);
        map.put("Element 5", 5);
        map.forEach((key, value) -> {
            System.out.println("Key " + key + " value " + value);
        });

//        Задача 2:
//        Реализуйте телефонную книгу с LinkedHashMap. Добавьте и найдите контакт.
        LinkedHashMap<String, Integer> contacts = new LinkedHashMap<>();
        contacts.put("Alsu", 1518);
        contacts.put("Anna", 4256);
        contacts.put("Mary", 8977);
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("Имя: " + name + " номер: " + contacts.get(name));
        } else System.out.println("Контакт не найден");

//        Задача 3:
//        Создайте LinkedHashMap, который хранит историю просмотров пользователя (максимум 10 элементов).
        LinkedHashMap<String, String> history = new LinkedHashMap<>();
        saveHistory(history,"1", "VK");
        saveHistory(history,"2", "Pikabu");
        saveHistory(history,"3", "Habr");
        saveHistory(history,"4", "QA auto");
        saveHistory(history,"5", "Youtube");
        saveHistory(history,"6", "Insta");
        saveHistory(history,"7", "Telega");
        saveHistory(history,"8", "VK");
        saveHistory(history,"9", "Web page");
        saveHistory(history,"10", "Test page");
        saveHistory(history,"11", "Ozon");
        saveHistory(history,"12", "QA");
        history.forEach((key, value) -> {
            System.out.println("Key " + key + " value " + value);
        });
    }

    public static void saveHistory(LinkedHashMap<String, String> history, String pageId, String pagename) {
        if (history.size() > 9) {
            history.pollFirstEntry();
        }
        history.put(pageId, pagename);
    }
}
