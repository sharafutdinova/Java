package practice.array_tasks;

import java.util.*;

//Удалить дубликаты сохранив порядок
public class DeleteDuplicates {
    static void main(String[] args) {
        int[] nums = {100, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3};
        printArray(deleteDuplicates(nums));
        printArray(deleteDuplicatesAdvanced(nums));
    }

    public static int[] deleteDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i]))
                list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] deleteDuplicatesAdvanced(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
