package practice.array_tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Поиск недублирующегося элемента
public class FindNotDuplicates {
    static void main(String[] args) {
        int[] arr_1 = {1, 2, 3, 4, 1, 2, 3};
        int[] arr_2 = {1, 2, 3, 4, 1, 2, 3, 4};
        System.out.println(findNotDuplicates(arr_1));//4
        System.out.println(findNotDuplicates(arr_2));//-1
    }

    public static int findNotDuplicates(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var t = map.entrySet().stream().filter((v) -> v.getValue() == 1).findFirst();
        return t.isEmpty() ? -1 : t.get().getKey();
    }
}
