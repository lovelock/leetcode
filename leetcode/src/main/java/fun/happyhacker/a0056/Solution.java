package fun.happyhacker.a0056;

import java.util.*;

// 首先是要按照每个数组中的第一个元素排序，这样可以保证相邻的区间是连续的，然后继续判断每个是否交叉即可
public class Solution {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        List<int[]> a = new ArrayList<>(Arrays.asList(intervals));


        // 这么写应该就是一个惯用法，查看源码可以发现，这里只要长度小于a.length，结果都是一样的
        int[][] r = a.toArray(new int[0][]);


        for (int[] ints : r) {
            System.out.println(Arrays.toString(ints));
        }

        Solution solution = new Solution();
        int[][] result = solution.merge(intervals);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 这个版本无法通过，因为后面会带空元素，不过这是不借助动态列表的方式
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        int[][] result = new int[intervals.length][];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] current = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result[j] = current;
                current = intervals[i];
                j++;
            }
        }
        result[j] = current;

        return result;
    }
}
