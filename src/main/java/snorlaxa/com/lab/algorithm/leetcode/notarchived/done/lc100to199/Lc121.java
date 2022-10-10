package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

/**
 * @Author: 余子毅
 * @Date: 2021/9/6 22:49
 * @题意: 买卖股票的最佳时机.给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 7,1,5,3,6,9
 */
public class Lc121 {
    public static int solution(int[] prices) {
        int max = 0, pre = 0;
        for (int i = 1; i < prices.length; i++) {
            int make = prices[i] - prices[i - 1];
            pre = Math.max(pre + make, 0);
            max = Math.max(max, pre);
        }
        return max;
    }

    /**
     * 对暴力法的思考
     * 迭代暴力
     *
     * @param prices price
     */
    public static int solution0(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int get = prices[j] - prices[i];
                if (get > max) {
                    max = get;
                }
            }
        }
        return max;
    }

    /**
     * 直接从迭代暴力算法中确定重复的情况，把他们记录下来
     *
     * @param prices price
     */
    public static int solution1(int[] prices) {
        int max = 0;
        int[][] dp = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            int maxsell = 0;
            for (int j = i + 1; j < prices.length; j++) {
                // 昨天不卖，今天卖，利润会变成多少
                dp[i][j] = dp[i][j - 1] - prices[j - 1] + prices[j];
                // 需要取i0买入后续卖出的所有天数里利润最大的一天
                if (dp[i][j] > maxsell) {
                    maxsell = dp[i][j];
                }
            }
            if (maxsell > max) {
                max = maxsell;
            }
        }
        return max;
    }

    /**
     * 去除遍历起始点的操作
     * 因为相同卖出点的情况下，利润最大方案的起始点一定在最低价格点，所以在过程中遇到最低价格点，要把起始点切换到这个点
     * dp[i][j-1]- price[j-1]+price[j] =price[j]-price[min]，如果这个值小于0，说明price[j]比price[min]还要小，那就后续如果有更大的利润，一定是从这个点买入的
     *
     * @param prices price
     */
    public static int solution2(int[] prices) {
        int dp = 0;
        int max = 0;
        for (int j = 1; j < prices.length; j++) {
            // 昨天不卖，今天卖，利润会变成多少
            // 如果当前价格更小，从当前价格开始，就不再需要遍历起始点了
            dp = Math.max(dp - prices[j - 1] + prices[j], 0);
            // 需要取i0买入后续卖出的所有天数里利润最大的一天
            dp = Math.max(dp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 9};
        int solution = solution1(prices);
        System.out.println(solution);
    }
}
