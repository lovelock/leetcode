package fun.happyhacker.fib;

import lombok.extern.slf4j.Slf4j;

// 动态规划和递归的思路不同在于 递归是自上而下的解决问题，是已知了简单问题的解决方法，不断重复它得到复杂问题的答案
// 常用的方式是记忆化搜索也是自顶向下的解决方式
// 而动态规划则是一种自下而上的解决方法
// 而且对于规模更大的问题，会出现栈溢出

// 动态规划: 将原问题拆解成若干子问题，同时保留子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案
@Slf4j
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 42000;
        long start = System.currentTimeMillis();
        long result = solution.fib(n);
        long end = System.currentTimeMillis();
        log.info("result: {}", result);
        log.info("cost time {} ms", end - start);
    }

    private long fib(int n) {
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }
}
