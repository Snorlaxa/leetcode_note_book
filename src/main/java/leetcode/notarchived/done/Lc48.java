package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/10 16:12
 * @题意: 旋转图像，90度
 */
public class Lc48 {
    public static void solution(int[][] matrix) {
        // 上下翻转后，对角线翻转
        int r = matrix.length;
        int c = matrix[0].length;
        // 翻转
        for (int i = 0; i < r / 2; i++) {
            for (int j = 0; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[r - i - 1][j];
                matrix[r - i - 1][j] = temp;
            }
        }
        // 转置
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{3,4},{1,2}};
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}};
        solution(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
