package leetcode.notarchived.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/6/13 22:25
 * @题意: 插入区间。在多个无重叠区间内插入一个新的区间，使得新生成的区间互不干扰
 */
public class Lc57 {
    public static int[][] solution(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int start = 0;
        int i;
        for (i = 0; i < intervals.length; i++) {
            // [1,4] [6,9] + [2,7] =>[1,9]
            // 找到第一个大于newInterval[0]的值，再往后找到第一个大于newInterval[1]的值
            // [1,A,3][5,B,7]=>[1,7]
            // [1,A,3][B][6,7]=>[1,B][6,7]
            // [1,3,A][5,B,7]=>[1,7]
            // [1,3][A][6,B,7]=>[1,3][A,7]
            if (start <= 0 && intervals[i][0] >= newInterval[0]) {
                // newInterval[0]落在空挡
                // 以A为起始
                start = newInterval[0];
                while (++i < intervals.length) {
                    if (intervals[i][0] > newInterval[1]) {
                        // B落空
                        res.add(newInterval);
                        break;
                    } else if (intervals[i][1] >= newInterval[1]) {
                        // B落在中间
                        res.add(new int[]{start, intervals[i][1]});
                        break;
                    }
                }
            } else if (start <= 0 && intervals[i][1] >= newInterval[0]) {
                // newInterval[0]落在中间
                // 以intervals[i][0]为起始
                start = intervals[i][0];
                if (i + 1 >= intervals.length) {
                    res.add(new int[]{start, newInterval[1]});
                } else
                    while (++i < intervals.length) {
                        if (intervals[i][0] > newInterval[1]) {
                            // B落空
                            res.add(new int[]{start, newInterval[1]});
                            break;
                        } else if (intervals[i][1] >= newInterval[1]) {
                            // B落在中间
                            res.add(new int[]{start, intervals[i][1]});
                            break;
                        } else if (i + 1 >= intervals.length) {
                            res.add(new int[]{start, newInterval[1]});
                        }
                    }
            } else {
                res.add(intervals[i]);
            }
        }
        if (i < intervals.length) res.add(intervals[intervals.length - 1]);
        return res.toArray(new int[0][]);
    }

    public static int[][] solution2(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> res = new ArrayList<>();
        // 未重叠
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        // 重叠部分 [0,1][2,4][5,9][11,13]
        // 从非重叠部分向后遍历，直到遇到第一个数大于newInterval[1]，中间遍历的数据就是重叠部分
        // 总结：当遍历无法确定边界时，可以先确定前后的条件，当遇到该条件时即停止遍历
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        // 剩余部分
        while (i < intervals.length) res.add(intervals[i++]);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}};
        int[] newInterval = new int[]{4, 8};
        int[][] solution = solution2(intervals, newInterval);
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
