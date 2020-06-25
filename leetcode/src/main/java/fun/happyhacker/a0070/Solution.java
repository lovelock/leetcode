package fun.happyhacker.a0070;

// 其实是递归的思想，先想明白要达成当前的位置，先需要到达的位置，按照条件只有两种
public class Solution {

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        int r = solution.climbStairs(n);
        System.out.println(r);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}
