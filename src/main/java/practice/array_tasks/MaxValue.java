package practice.array_tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class MaxValue {
    static void main(String[] args) {
        int[] nums = {100, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3};
        int[] negativeNums = {-2, -3, -7, -1, -2};
        System.out.println(findMax(nums).orElse(-1));
        System.out.println(findSecondMax(nums).orElse(-1));
        System.out.println(findSecondMax(negativeNums).orElse(-1));
        System.out.println(getSum(nums));
    }

    public static OptionalInt findMax(int[] arr) {
        return Arrays.stream(arr).max();
    }

    //Поиск второго максимального
    public static OptionalInt findSecondMax(int[] arr) {
        return Arrays.stream(arr)
                .distinct().boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .max();
    }

    public static Integer getSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");
        return Arrays.stream(arr).sum();
    }
}
