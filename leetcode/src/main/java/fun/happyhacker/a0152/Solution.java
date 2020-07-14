package fun.happyhacker.a0152;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,-2,4};
        int[] nums = new int[]{-2, 0, -1};
        var solution = new Solution();
        int max = solution.maxProduct(nums);
        log.info("max {}", max);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxProductMemo = new int[nums.length + 1];
        int[] minProductMemo = new int[nums.length + 1];

        maxProductMemo[0] = nums[0];
        minProductMemo[0] = nums[0];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxProductMemo[i] = max(nums[i], maxProductMemo[i - 1] * nums[i], minProductMemo[i - 1] * nums[i]);
            minProductMemo[i] = min(nums[i], maxProductMemo[i - 1] * nums[i], minProductMemo[i - 1] * nums[i]);
            max = Math.max(max, maxProductMemo[i]);
        }

        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), Math.max(a, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), Math.min(a, c));
    }
}
