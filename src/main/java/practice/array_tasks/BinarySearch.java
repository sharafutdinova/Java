package practice.array_tasks;

import java.util.Arrays;

//Бинарный поиск в отсортированном массиве
public class BinarySearch {
    static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(nums, 7));//true
        System.out.println(binarySearch(nums, 0));//false
    }

    public static boolean binarySearch(int[] arr, int value) {
        boolean isFound = false;
        int halfInd = arr.length / 2 + arr.length % 2 - 1;
        while (!isFound && halfInd >= 0) {
            if (value == arr[halfInd]) {
                isFound = true;
            }
            if (value > arr[halfInd]) {
                arr = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
            } else {
                arr = Arrays.copyOfRange(arr, 0, arr.length / 2);
            }
            halfInd = arr.length / 2 + arr.length % 2 - 1;
        }
        return isFound;
    }
}
