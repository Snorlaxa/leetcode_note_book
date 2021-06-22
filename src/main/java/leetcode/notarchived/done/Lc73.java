package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/21 9:40
 * @题意: 矩阵置零。把矩阵中存在0的行和列全部置0
 * 1 0 1 0 1
 * 1 1 1 1 1
 * 0 0 1 0 1
 * <p>
 * 1 0 1 0 1
 * 1 1 1 1 1
 * 0 0 1 0 1
 * 1. bitmap 记录是否改变
 */
public class Lc73 {
    /**
     * 空间复杂度级别还是m*n
     *
     * @param matrix 原始矩阵
     * @return 置零矩阵
     */
    public static int[][] solution01(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return new int[][]{};
        int c = matrix[0].length;
        int[] bitmap = new int[r * c / 32 + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int position = i * c + j;
                if (matrix[i][j] == 0 && !isOne(bitmap, position)) {
                    // 如何判断是真的0还是改变后的0
                    // 如果不用逻辑判断，则需要一个标记位，这个标记位必须能用常量级别的数据存储
                    for (int k = 0; k < c; k++) {
                        if (matrix[i][k] != 0) setOne(bitmap, i * c + k);
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < r; k++) {
                        if (matrix[k][j] != 0) setOne(bitmap, k * c + j);
                        matrix[k][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    private static void setOne(int[] bitmap, int position) {
        int x = position >> 5;
        int y = position & 31;
        bitmap[x] |= 1 << y;
    }

    private static boolean isOne(int[] bitmap, int position) {
        int x = position >> 5;
        int y = position & 31;
        return (bitmap[x] & (1 << y)) != 0;
    }

    /**
     * 优化标记法
     * 扫两遍，第一遍记录哪行有0，哪一列有0，第二遍更改
     * 再次优化，用第一行和第一列来替代需要额外开辟的空间，并使用标记来判断第一行和第一列是否原本就有0，倒序遍历后，最后根据标记位来更新这两列即可
     *
     * @param matrix 原始矩阵
     * @return 置零矩阵
     */
    public static void solution02(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return;
        int c = matrix[0].length;
        int firstcol = 0, firstrow = 0;
        // 标记0行0列
        for (int i = 0; i < c; i++)
            if (matrix[0][i] == 0) {
                firstrow = 1;
                break;
            }

        for (int i = 0; i < r; i++)
            if (matrix[i][0] == 0) {
                firstcol = 1;
                break;
            }


        // 标记
//        for (int i = r - 1; i > 0; i--)
//            for (int j = c - 1; j > 0; j--)
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
//                }

        for (int i = 1; i < r; i++)
            for (int j = 1; j < c; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        // 根据标记修改
        for (int i = r - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                // 该行有0
                for (int k = 1; k < c; k++) matrix[i][k] = 0;
            }
        }

        for (int i = c - 1; i > 0; i--) {
            if (matrix[0][i] == 0) {
                // 该列有0
                for (int k = 1; k < r; k++) matrix[k][i] = 0;
            }
        }

        if (firstrow == 1) for (int k = 0; k < c; k++) matrix[0][k] = 0;
        if (firstcol == 1) for (int k = 0; k < r; k++) matrix[k][0] = 0;
    }

    // 优化版
    public static void solution3(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return;
        int c = matrix[0].length;
        boolean iszero = false;
        // 标记
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) iszero = true;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置零
        // 需要倒着访问，不然会把第一行标记更新掉
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            // 一行遍历完，这一行的标记已经不需要了，如果第一列有0可以置0
            if (iszero) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };

        /*
         * 结果
         * {0,0,0,0},
         * {0,0,0,0},
         * {0,1,0,0}
         */
        solution3(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
