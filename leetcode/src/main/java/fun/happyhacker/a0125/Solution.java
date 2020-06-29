package fun.happyhacker.a0125;

import lombok.extern.slf4j.Slf4j;

// 解答的关键在于数据的预处理，把其中的非字母的字符去掉，可以通过正则匹配，也可以通过Java的内置方法Character.isLetterOrDigit
// 然后全部转换为统一的大写或小写

// 刚开始的思路是对的，不用开辟新的空间存放新的字符串，这里重新写一下
@Slf4j
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        boolean r1 = solution.isPalindrome(s1);
        boolean r2 = solution.isPalindrome(s2);
        log.info("r1 {}", r1);
        log.info("r2 {}", r2);
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String s1 = sb.toString().toLowerCase();
        log.info("s1 {}", s1);

        int head = 0;
        int end = s1.length() - 1;

        while (head < end) {
            if (s1.charAt(head) != s1.charAt(end)) {
                return false;
            } else {
                head++;
                end--;
            }
        }

        return true;
    }
}
