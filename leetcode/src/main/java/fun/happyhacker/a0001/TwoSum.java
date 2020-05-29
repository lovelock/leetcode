package fun.happyhacker.a0001;

import java.util.*;

/**
 * Hello world!
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] sums = new int[]{3,2,4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(sums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}
