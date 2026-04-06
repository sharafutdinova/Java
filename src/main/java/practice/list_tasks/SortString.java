package practice.list_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortString {
    static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Alsu", "Ben", "Sam", "Anna"));
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 2, 4, 5));
        System.out.println(sortByLength(list));
    }

    //Сортировка по длине строк
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
//        return strings.stream().sorted(Comparator.comparing(word -> word.length())).toList();
    }
}
