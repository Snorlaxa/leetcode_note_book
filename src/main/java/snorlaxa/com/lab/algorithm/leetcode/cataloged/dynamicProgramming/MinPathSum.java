package snorlaxa.com.lab.algorithm.leetcode.cataloged.dynamicProgramming;

/**
 * @Author: Yzy
 * @Date: 2021/1/19 14:24
 * @题意: 求从矩阵的左上角到右下角的最小路径和（即路过的点相加），每次只能向右和向下移动。
 * @题解: 考虑右下角f(i, j)跟哪些元素有关，再看这些元素的存储方式是否能缩减空间。
 * f(i,j)=Min(f(i,j-1),f(i-1,j))+grid(i,j);即只跟上方和右方的结果有关，
 * 但我们应该是一行行遍历的，遍历下一行时会从第一列开始，这意味着必须记录上一行的结果，否则拿不到f(i,j-1)的值。
 * 但可以预见的是，仅仅需要上一行的结果即可，其余已经访问过的行结果可以丢弃。所以需要一个一维数组来记录。
 */
public class MinPathSum {
    public static int solution(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[] dp = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // dp[j-1] => f(i-1,j)
                // dp[j] => f(i,j-1)
                int left = j > 0 ? dp[j - 1] : dp[j];
                int top = i > 0 ? dp[j] : left;
                dp[j] = Math.min(top, left) + grid[i][j];
            }
        }
        return dp[c - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {2, 1, 3}, {3, 4, 2}};
        System.out.println(solution(grid));
    }
}
