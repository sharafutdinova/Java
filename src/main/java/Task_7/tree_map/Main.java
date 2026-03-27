package Task_7.tree_map;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        Задача 1:
//        Создайте TreeMap и добавьте 5 ключей (имена) и значений (баллы). Выведите отсортированные данные.
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Alsu", 16);
        map.put("Kate", 19);
        map.put("Anna", 10);
        map.put("Mary", 20);
        map.put("Sally", 15);
        map.forEach((key, value) -> System.out.println("Name: " + key + " points: " + value));

//        Задача 2:
//        Найдите минимальный и максимальный ключ в TreeMap.
        System.out.println("Минимальный ключ " + map.firstEntry());
        System.out.println("Максимальный ключ " + map.lastEntry());

//        Задача 3:
//        Реализуйте TreeMap, который хранит сотрудников и их ID, с возможностью поиска ближайшего большего ID.
        TreeMap<Integer, String> employees = new TreeMap<>();
        employees.put(1, "Alsu");
        employees.put(10, "Mary");
        employees.put(41, "Kate");
        employees.put(89, "Lily");
        employees.put(62, "Anna");
        Integer key = employees.higherKey(11);
        if (key != null)
            System.out.println("Ближайшее id " + key);
        else System.out.println("Нет ближайшего id");
    }
}
