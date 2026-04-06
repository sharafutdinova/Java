package practice.array_tasks;

import java.util.stream.IntStream;

//Развернуть массив
public class ReverseArray {
    static void main(String[] args) {
        int[] nums = {100, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3};
        printArray(reverseArray(nums));
    }

    public static int[] reverseArray(int[] arr) {
        return IntStream.range(0, arr.length).map(i->arr[arr.length-i-1]).toArray();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
