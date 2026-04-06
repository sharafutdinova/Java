package practice.array_tasks;

import java.util.Arrays;

//Удалить все вхождения определенного числа
public class RemoveSomeNumber {
    static void main(String[] args) {
        int[] nums = {100, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3};
        printArray(deleteNumber(nums, 2));
    }

    public static int[] deleteNumber(int[] arr, int num) {
        return Arrays.stream(arr).filter(number -> number != num).toArray();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
