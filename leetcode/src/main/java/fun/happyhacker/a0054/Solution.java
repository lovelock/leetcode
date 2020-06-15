package fun.happyhacker.a0054;

import java.util.ArrayList;
import java.util.List;

// 把边界问题搞清楚即可
public class Solution {

    public static void main(String[] args) {
        int[][]matrix = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        String direction = "right";
        List<Integer> result = new ArrayList<>();
        /*
         * [1,2,3,4],
         * [5,6,7,8],
         * [9,10,11,12]
         */

        while (left <= right && top <= bottom) {
            switch (direction) {
                case "right":
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top++;
                    direction = "down";
                    break;
                case "down":
                    for (int i = top; i <= bottom; i++) {
                        result.add(matrix[i][right]);
                    }
                    right--;
                    direction = "left";
                    break;
                case "left":
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                    direction = "top";
                    break;
                default:
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                    direction = "right";
                    break;
            }
        }

        return result;
    }
}
