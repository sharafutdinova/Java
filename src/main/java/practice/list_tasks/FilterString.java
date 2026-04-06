package practice.list_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterString {
    static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Alsu", "Ben", "Sam", "Anna"));
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 2, 4, 5));
        System.out.println(filterString(list, "A"));
        System.out.println(removeDuplicates(nums));
        System.out.println(filterOdds(nums));
    }

    //Фильтрация списка строк по префиксу
    public static List<String> filterString(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.indexOf(substring) == 0).toList();
    }

    //Удаление дубликатов
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().toList();
//        return new ArrayList<>(new HashSet<>(list));
    }

    //Фильтрация списка чисел по четности
    public static List<Integer> filterOdds(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).toList();
    }
}
