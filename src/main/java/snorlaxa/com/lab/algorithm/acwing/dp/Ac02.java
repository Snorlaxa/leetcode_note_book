package snorlaxa.com.lab.algorithm.acwing.dp;

/**
 * @Author: Yzy
 * @Date: 2021/9/11 19:30
 * @题解: 01背包问题
 */
public class Ac02 {
    /**
     * 二维暴力动态规划
     * <p>
     * f[i][j]前i个物品中，选择的背包容量是j的情况下，总价值最大是多少（跟题目的定义是非常相像的）
     * 1. 不选择第i个物品，f[i][j]=f[i-1][j]
     * 2. 选择第i个物品，f[i][j] = f[i-1][j-v[i]]+w[i]
     * 取1、2两种情况的较大者
     * <p>
     * 初始化：f[0][0] = 0
     *
     * @param o 容量
     * @param v 体积
     * @param w 价值
     * @return 可带走的最大价值
     */
    public static int solution(int o, int[] v, int[] w) {
        // 从1开始，因为计算时依赖于前面阶段的状态，而第一个阶段的状态是f[0][0]=0
        // 长度需要+1，因为对dp的定义中前i个中的容量为j的结果，而i=0表示没有物品，所以结果的状态是比物品数量多一个的
        int[] dp = new int[o + 1];
        for (int i = 1; i < v.length; i++) {
            // 能放下物品的容量是多少
            // 在循环中判断，只需要找j>v[i]的就行
            for (int j = o; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        // 最后一个状态就是最大值，因为在状态转移的过程中，dp[o]一定是从最优解转移过来的，或者本身就是最优解，而转移方程是dp[j] = Math.max(dp[j],xxx),
        // 最优解一定是最大的，所以这个转移会导致从最优解开始后续的一系列结果都与最优解的值相同
        // 什么情况下不能用dp[o]作为最优解？当dp[o]的转移过程不会经过最优解时，就不能使用。
        // 那为什么dp一定会经过最优解转化呢？因为dp[o]是从任意一个初始状态转化过来，这个初始状态都是0，中途经过的
        // 从定义上看，dp[o]表示的是体积不超过o的物品的最大价值，而非体积等于o的物品价值，所以这个值是包括了最优解的。
        // 在过程中是如何维护这个定义的？在某个容量下，会遍历所有前i个物体的可能情况，在这i个方案里，选出一个最大的，此时这个最大的值肯定包括此容量下的最优解
        return dp[o];
    }

    public static void main(String[] args) {
        int[] vs = {2, 4, 3, 7};
        int[] ws = {2, 3, 5, 5};
        int solution = solution(10, vs, ws);
        System.out.println(solution);
    }
}
