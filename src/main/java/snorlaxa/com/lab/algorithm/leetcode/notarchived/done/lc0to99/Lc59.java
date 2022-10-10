package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

/**
 * @Author: Yzy
 * @Date: 2021/6/14 17:39
 * @题意: 螺旋矩阵2。给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 如：
 * 1 2 3
 * 8 9 4
 * 7 6 5
 */
public class Lc59 {
    public static int[][] solution(int n) {
        int r0 = 0, r1 = n - 1;
        int c0 = 0, c1 = n - 1;
        int[][] res = new int[n][n];
        int len = n * n;
        int k = 0;
        while (r0 <= r1 && c0 <= c1) {
            // 从左到右
            if (k > len) break;
            for (int i = c0; i <= c1; i++) res[r0][i] = ++k;
            r0++;
            if (k > len) break;
            // 从上到下
            for (int i = r0; i <= r1; i++) res[i][c1] = ++k;
            c1--;
            if (k > len) break;
            // 从右到左
            for (int i = c1; i >= c0; i--) res[r1][i] = ++k;
            r1--;
            if (k > len) break;
            // 从下到上
            for (int i = r1; i >= r0; i--) res[i][c0] = ++k;
            c0++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] solution = solution(3);
        for (int[] arr : solution) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
