package fun.happyhacker.a0066;

import java.util.Arrays;

// 如果一个位置不是9，那么直接加了1返回即可
// 如果一个位置是9，就需要把它变成0，直接改成0, 如果每一位都是9，那么最后的结果就是每一位都是0，这样就需要在第0位的前面补上1
// 注意new int[10]生成的结果就是10个0的数组，所以没有必要再把digits中的所有0重新复制到新数组
public class Solution {
    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        Solution solution = new Solution();
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;

        return result;
    }
}
