package fun.happyhacker.a0049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            String sorted = Stream.of(str.split("")).sorted().collect(Collectors.joining(""));
            if (!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(str);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

}
