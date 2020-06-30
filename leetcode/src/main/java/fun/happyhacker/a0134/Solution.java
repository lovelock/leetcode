package fun.happyhacker.a0134;

import lombok.extern.slf4j.Slf4j;

// 从任意一个位置出发，如果到某一个点的时候剩余油量为负数了，那么应该从这个点的下一个点重新出发开始计算
// 这个原理是对于中间的任何一个点，既然能从起点到达，那么在这里时的剩余油量一定是>=0，这时候都不能到达这个点
// 那么从任意这些中间的点出发的时候剩余油量都是0，也就更不可能到达
// 这里一个比较迷惑的是为什么start = i + 1，是因为执行到i的时候其实还没有到达下一个点，只是计算出无法到达下一个点，但
// 还没有移动到下一个点
@Slf4j
public class Solution {
    public static void main(String[] args) {
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int[] gas = new int[]{1, 2, 3, 4, 5};

//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};
        Solution solution = new Solution();
        int num = solution.canCompleteCircuit(gas, cost);
        log.info("num {}", num);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = sum(gas);
        log.info("sum gas: {}", sumGas);
        int sumCost = sum(cost);
        log.info("sum cost: {}", sumCost);
        if (sumCost > sumGas) {
            return -1;
        }

        int totalGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalGas -= cost[i];
            if (totalGas < 0) {
                totalGas = 0;
                start = i+1;
            }
        }

        return start;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
