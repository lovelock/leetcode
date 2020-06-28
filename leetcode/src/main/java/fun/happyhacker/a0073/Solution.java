package fun.happyhacker.a0073;

import fun.happyhacker.utils.Matrix;

// 总体思路是，既然不能开辟新的空间，那么就用第一行和第一列来存储相应的行/列是否存在0，如果存在则在下一次循环中把对应的行和列全都设置为0
// 但这种思路无法覆盖第一行或第一列本来就有0的情况，所以需要在一开始就把第一行和第一列是否有0记录下来，在完成上述操作后，再把第一行和第一列是否有0
// 的情况过一遍，如果有，就把第一行或者第一列分别全都设置为0
// 显而易见的是，为什么在最后才把第一行或第一列是否有0用上呢？因为如果在前面用了，就先把第一行或第一列直接全搞成0了，就没办法做后面的记号了
// 这里使用第一行和第一列做记号，其实也可以选择任意行任意列，只是用第一行第一列更直观，代码也更好写一些
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        Matrix.print(matrix);
    }

    public void setZeroes(int[][] matrix) {
        boolean firstColHasZero = false;
        boolean firstRowHasZero = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
