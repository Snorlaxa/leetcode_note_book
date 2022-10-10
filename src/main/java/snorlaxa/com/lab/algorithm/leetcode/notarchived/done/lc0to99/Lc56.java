package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/6/13 11:08
 * @题意: 合并区间
 */
public class Lc56 {
    public static int[][] solution(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length - 1; i++) {
            int[] temp = intervals[i];
            while (i < intervals.length - 1 && temp[1] >= intervals[i + 1][0]) {
                temp[1] = Math.max(temp[1], intervals[i + 1][1]);
                i++;
            }
            res.add(temp);
        }
        if (i < intervals.length) res.add(intervals[intervals.length - 1]);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {3,5}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 4}, {0,4}};
        int[][] solution = solution(intervals);
        for (int[] pair : solution) {
            System.out.print("[");
            System.out.print(pair[0]);
            System.out.print(",");
            System.out.print(pair[1]);
            System.out.print("]");
            System.out.print(" ");
        }
    }
}
