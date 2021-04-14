package leetcode.cataloged.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: Yzy
 * @Date: 2021/1/19 15:32
 * @题意: 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动
 * @题解: f(i, j) = f(i, j-1) + f(i-1, j)
 * @注意： 当第一行结果可以确定时，就可以直接赋值，就不考虑第一行的特殊情况了，同理第一列也是一样，直接从f(1,1)开始计算
 */
public class UniquePaths {
    public static int solution(int m, int n) {
        int[] dp = new int[n];
        // 第一行计算结果都为1
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }
}
