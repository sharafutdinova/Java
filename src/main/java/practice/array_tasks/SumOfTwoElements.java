package practice.array_tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Вывести индексы элментов, сумма которых равна target
public class SumOfTwoElements {
    static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 6, 9, 0, 5, 7}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 6, 9, 0, 5, 7}, 90)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
            System.out.println("Added " + nums[i]);
        }
        return new int[0];
    }
}
