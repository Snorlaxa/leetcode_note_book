package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

public class Lc221 {
    /**
     * 动态规划 O(n^2)
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r + 1][c + 1];
        int max = 0;
        for (int i = 1; i <= r; i++)
            for (int j = 1; j <= c; j++)
                if (matrix[i - 1][j - 1] == '1') dp[i][j] = 1;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                // 取最小的，如果其中有一个是0，就取到了0+1，得到正确答案
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] matrix = new char[][]{{'0'}};
        int i = maximalSquare(matrix);
        System.out.println(i);
    }
}
