package fun.happyhacker.a0049;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> list = solution.groupAnagrams(strs);
        System.out.println(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] nums = new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[(int) str.charAt(i) - 97]++;
            }
            String key = IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.joining(""));
            if (!map.containsKey(key)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(key, tmp);
            } else {
                map.get(key).add(str);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

}
