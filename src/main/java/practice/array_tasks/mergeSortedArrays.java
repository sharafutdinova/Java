package practice.array_tasks;

import java.util.Arrays;

//Слияние двух отсортированных массивов
public class mergeSortedArrays {
    static void main(String[] args) {
        int[] arr_1 = {1, 3, 5, 7};
        int[] arr_2 = {0, 3, 4, 7, 9};
        System.out.println(Arrays.toString(mergeArrays(arr_1, arr_2)));
        System.out.println(Arrays.toString(mergeSortedArrays(arr_1, arr_2)));
    }

    public static int[] mergeArrays(int[] arr_1, int[] arr_2) {
        int i_1 = 0, i_2 = 0, i = 0;
        int[] newArr = new int[arr_1.length + arr_2.length];
        while (i_1 < arr_1.length && i_2 < arr_2.length) {
            if (arr_1[i_1] < arr_2[i_2]) {
                newArr[i] = arr_1[i_1];
                i_1++;
            } else {
                newArr[i] = arr_2[i_2];
                i_2++;
            }
            i++;
        }
        for (int j = i_1; j < arr_1.length; j++) {
            newArr[i] = arr_1[j];
            i++;
        }
        for (int j = i_2; j < arr_2.length; j++) {
            newArr[i] = arr_2[j];
            i++;
        }
        return newArr;
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }
}
