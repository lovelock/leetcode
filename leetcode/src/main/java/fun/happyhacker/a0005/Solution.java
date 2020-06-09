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

        String s1 = "";
        String s2 = "";
        for (int i = 0; i < str.length(); i++) {
            String tmp1 = expandAroundCenter(str, i - 1, i + 1);
            s1 = s1.length() > tmp1.length() ? s1 : tmp1;
            String tmp2 = expandAroundCenter(str, i, i + 1);
            s2 = s2.length() > tmp2.length() ? s2 : tmp2;
        }

        return s1.length() > s2.length() ? s1 : s2;
    }

    private String expandAroundCenter(String str, int left, int right) {
        int start = 0;
        int maxLength = 1;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (maxLength < right - left + 1) {
                maxLength = right - left + 1;
                start = left;
            }
            left--;
            right++;
        }

        return str.substring(start, start + maxLength);
    }
}
