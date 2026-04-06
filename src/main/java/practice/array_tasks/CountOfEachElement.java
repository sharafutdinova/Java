package practice.array_tasks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfEachElement {
    static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3, 2};
        int[] nullArr = null;
        System.out.println(getCountOfEachElement(nums));
        System.out.println(getFrequentElement(nums));
        System.out.println(getCountOfEachElement(nullArr));
    }

    //Количество каждого элемента
    public static Map<Integer, Long> getCountOfEachElement(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");
        return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //Самый частый элемент
    public static Integer getFrequentElement(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");
        var map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var maxFrequent = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        return maxFrequent.isPresent() ? maxFrequent.get().getKey() : -1;
    }
}
