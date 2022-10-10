/**
 * @Author: 余子毅
 * @Date: 2021/6/8 11:11
 * @题意: 螺旋矩阵。顺时针螺旋顺序返回矩阵
 */
package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

import java.util.ArrayList;
import java.util.List;

public class Lc54 {
    public static List<Integer> solution(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int r0 = 0, r1 = matrix.length - 1;
        int c0 = 0, c1 = matrix[0].length - 1;
        int len = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (r0 <= r1 && c0 <= c1) {
            // 从左到右
            if (res.size() >= len) break;
            for (int i = c0; i <= c1; i++) res.add(matrix[r0][i]);
            r0++;
            if (res.size() >= len) break;
            // 从上到下
            for (int i = r0; i <= r1; i++) res.add(matrix[i][c1]);
            c1--;
            if (res.size() >= len) break;
            // 从右到左
            for (int i = c1; i >= c0; i--) res.add(matrix[r1][i]);
            r1--;
            if (res.size() >= len) break;
            // 从下到上
            for (int i = r1; i >= r0; i--) res.add(matrix[i][c0]);
            c0++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
//        int[][] matrix = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6}
//        };
        List<Integer> solution = solution(matrix);
        for (int i : solution) {
            System.out.print(i + " ");
        }
        // when
        System.out.println();
        System.out.print("1 2 3 4 8 12 11 10 9 5 6 7");
    }
}