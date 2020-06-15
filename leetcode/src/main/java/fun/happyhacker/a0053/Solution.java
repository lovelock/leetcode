package fun.happyhacker.a0053;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int max = solution.maxSubArray(nums);
        System.out.println(max);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] window = new int[nums.length];
        window[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            window[i] = Math.max(nums[i] + window[i-1], nums[i]);
            max = Math.max(max, window[i]);
        }


        return max;
    }
}
