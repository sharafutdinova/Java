package practice.array_tasks;

//Маскимальная сумма подмассива длиной K
public class MaxSubArrayValue {
     static void main(String[] args) {
        int[] nums = {100, 2, 3, 4, 5, 5, 2, 1, 8, 9, 3};
        int maxSum = getMaxSum(nums, 3);//4+5+5=14
        System.out.println(maxSum);
    }

    public static int getMaxSum(int[] arr, int k) {
        int maxSum = 0;
        if (arr.length >= k) {
            for (int i = 0; i < k; i++) {
                maxSum += arr[i];
            }
            int addSum = maxSum;
            for (int i = k; i < arr.length; i++) {
                addSum = addSum - arr[i - k] + arr[i];
                if (addSum > maxSum)
                    maxSum = addSum;
            }
        } else return -1;
        return maxSum;
    }
}
