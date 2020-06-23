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
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] current = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(interval[1], current[1]);
            } else {
                result.add(current);
                current = interval;
            }
        }
        result.add(current);

        return result.toArray(new int[0][]);
    }
}
