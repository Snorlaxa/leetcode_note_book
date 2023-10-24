package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc300to400;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class Lc309 {
    /**
     * 自动状态机，有三种状态：
     * 1.手里持有股票，可能是今天买的，或者是一直持有的
     * 2.手里不持有股票，可能是今天卖的（从持有股票的状态转移过来）
     * 3.手里不持有股票，但不是今天卖的（从卖了的状态转移过来或者一直都没有买）
     *
     * @param prices 股票价格
     * @return 最大利润
     */
    public static int maxProfit(int[] prices) {
        int dp1 = -prices[0]; // 手里有股票，今天买的或者不是今天买的
        int dp2 = 0; // 手里没股票，是今天卖的，第二天进入冻结期
        int dp3 = 0; // 手里没股票，不是今天卖的，第二天不是冻结期

        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp3 - prices[i]); // 今天买了，从冻结期状态转移过来，或者是没有买，保持原样
            dp3 = Math.max(dp2, dp3); // 手里没股票，不操作，可以从以前的2或者3转移过来
            dp2 = dp1 + prices[i]; // 今天卖了，从持有股票的状态转移过来
        }
        return Math.max(dp2, dp3);
    }

    public static int maxProfit2(int[] prices) {
        int dp1 = -prices[0]; // 手里有股票，今天买的或者不是今天买的
        int dp2 = 0; // 手里没股票
        int dp3 = 0;// 记录冻结期的收益

        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp2 - prices[i]); // 手里有股票，一直有或者从今天买的，但如果前一天刚卖出，是不能买入的，所以不能从买入的dp2状态转移过来，要一个新状态
            dp2 = Math.max(dp1 + prices[i], dp3); // 手里没股票，今天卖出的，或者从冻结期出来，怎么知道冻结期的收益呢？需要记录冻结期的收益
            dp3 = dp2;// 卖出后冻结期的收益
        }
        return Math.max(dp2, dp3);
    }
}
