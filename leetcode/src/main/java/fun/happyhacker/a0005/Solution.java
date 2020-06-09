package fun.happyhacker.a0005;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ababd";
        String substr = solution.longestPalindromicSubstring(str);
        System.out.println(substr);
    }

    public String longestPalindromicSubstring(String str) {
        if (str.length() < 2) {
            return str;
        }

        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (check(str, left, right)) {

                if (maxLength < right-left+1) {
                    maxLength = right-left+1;
                    start = left;

                }

                left--;
                right++;

            }

        }

        for (int i = 0; i < str.length(); i++) {
            int left = i;
            int right = i + 1;
            while (check(str, left, right)) {
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }

        }

        return str.substring(start, start + maxLength);
    }

    private boolean check(String str, int left, int right) {
        if (left < 0 || right > str.length() - 1) {
            return false;
        }

        return str.charAt(left) == str.charAt(right);
    }
}
