package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/8/8 23:47
 * @题意: 三角形最小路径和，每个值只能从上一层相邻的两个位置进行访问，求从上到下最短路径
 *      2
 *     3,4
 *    6,5,7
 *   4,1,8,3
 */
public class Lc120 {
    public static int solution(List<List<Integer>> triangle) {
        /**
         * dp[i][j] = if(i>0&&i<n-1) min(dp[i-1][j-1],dp[i-1][j])+val
         *          = if(i==0) min(dp[i-1][j],dp[i-1][j+1])+val // 当前值与[i,j+1]相同
         *          = if(i==n-1) min(dp[i-1][j-2],dp[i-1][j-1])+val // 当前值与[i,j-1]相同
         */
        int[] dp = new int[216];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == row.size() - 1) dp[j] = Math.min(dp[j - 1], dp[j - 2]) + row.get(j);
                else if (j == 0) dp[j] = dp[j + 1] - row.get(j + 1) + row.get(j);
                else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
                }
            }
        }
        int min = 10001;
        for (int j : dp) if (j < min) min = j;
        return min;
    }

    public static void main(String[] args) {

    }
}
