package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/8/8 23:47
 * @题意: 三角形最小路径和，每个值只能从上一层相邻的两个位置进行访问，求从上到下最短路径
 * 2
 * 3,4
 * 6,5,7
 * 4,1,8,3
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
            if (i == 0) {
                dp[0] = row.get(0);
                continue;
            }
            if (i == 1) {
                int t = dp[0];
                dp[1] = dp[0] + row.get(1);
                dp[0] = t + row.get(0);
                continue;
            }
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == row.size() - 1) dp[j] = Math.min(dp[j - 1], dp[j - 2]) + row.get(j);
                else if (j == 0) dp[j] = dp[j + 1] - row.get(j + 1) + row.get(j);
                else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
                }

            }
        }
        int min = 10001;
        for (int i = 0; i < triangle.size(); i++) {
            if (dp[i] < min) min = dp[i];
        }
        return min;
    }

    /**
     * 自底向上规避边界问题
     * dp[i][j]表示从该位置出发到底边的最小值
     * 计算的方法是从底边开始向上计算，从dp中取出的已经是最小路线的和了
     * 2
     * 3,4
     * 6,5,7
     * 4,1,8,3
     *
     * 如上图dp[2,1]为6能接触到的下层的4和1中较小的那个，即6+1=7
     * 最终汇总到第一层即可从dp[0]直接获取到最小值，不用取min
     * @param triangle
     * @return
     */
    public static int solution2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + row.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
