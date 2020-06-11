package fun.happyhacker.a0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 双指针思想
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
