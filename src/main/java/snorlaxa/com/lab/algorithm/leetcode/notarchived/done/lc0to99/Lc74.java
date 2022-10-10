package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

/**
 * @Author: 余子毅
 * @Date: 2021/6/21 21:14
 * @题意: 搜索二维矩阵。行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
 * @题解: 二分查找
 */
public class Lc74 {
    public static boolean solution(int[][] matrix, int target) {
        /*
        先二分查找第一列，再查找行
        第一列查找大于目标的第一个数的前一行
         */
        // 查找第一列
        int row = matrix.length;
        int l = 0, r = row - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                // 如果mid小于target，是有可能作为最终取值的，所以用l=mid
                l = mid;
            }
        }
        int[] arr = matrix[l];
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) {
                l = mid + 1;
            } else r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 7},
                {8, 9, 10, 13},
                {17, 18, 20, 23},
                {43, 45, 48, 59, 60}
        };
//        int[][] matrix = new int[][]{
//                {1, 2},
//                {8, 9}
//        };
        boolean solution = solution(matrix, 8);
        System.out.println(solution ? '是' : '否');
    }
}
