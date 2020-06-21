package fun.happyhacker.a0055;

// 跳跃游戏，动态规划，贪心算法
// 在每一步找到能跳到的最远的地方，如果能直接跳到就返回了，如果不能跳到最后就换下一个开始跳
// 下一个可以跳到的最远位置就是i+nums[i]和reach本身的最大值
// 有了这个概念其实就可以知道，在这次跳跃之后因为i++了，如果在下一次循环的时候i>reach了，说明reach就跟不上i了
// 也就永远也达不到最后了
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        Solution solution = new Solution();
        boolean result = solution.canJump(nums);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }

        return true;
    }

}
