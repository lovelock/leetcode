package fun.happyhacker.a0062;

// 首先要明白的前提是一个点的能到达的路径的条数等于它左侧的点可以到达的条数加上它上面的点可以到达的条数
// 知道了这个就可以往前推了，很容易的可以知道第一行和第一列的所有位置都是1
// 然后就可以推算出其他的所有节点的值了，而结果就是最后一个计算出来的值
public class Solution {
    public int uniqPaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int row = 0; row < n; row++) {
            memo[row][0] = 1;
        }
        for (int col = 0; col < m; col++) {
            memo[0][col] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                memo[row][col] = memo[row - 1][col] + memo[row][col - 1];
            }
        }

        return memo[n-1][m-1];
    }
}
