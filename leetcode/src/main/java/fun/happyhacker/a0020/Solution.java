package fun.happyhacker.a0020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "[]]";
        Solution solution = new Solution();
        boolean b = solution.isValid(s);
        System.out.println(b);
    }
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");

        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));

            if (map.containsKey(current)) {
                queue.push(map.get(current));
            } else {
                if (queue.isEmpty()) {
                    return false;
                }

                if (!current.equals(queue.pop())) {
                    return false;
                }
            }
        }

        return queue.isEmpty();
    }
}
