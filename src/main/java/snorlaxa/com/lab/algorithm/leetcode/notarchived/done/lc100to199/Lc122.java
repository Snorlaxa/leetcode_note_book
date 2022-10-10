package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

/**
 * @Author: 余子毅
 * @Date: 2021/9/6 22:49
 * @题意: 买卖股票的最佳时机2. 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 7,1,5,3,6,4
 */
public class Lc122 {
    public static int solution(int[] prices) {
        int max = 0, pre = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当最低价格在price[i]时，说明必须要在前一次卖出，并在此处重新买入。
            // 如果本次仍然卖出，相当于增加了利润，pre+make，如果本次不卖出，而是买入，则pre等于前一次卖出的利润，而本次是买入所以没有利润，所以make为0
            int make = Math.max(prices[i] - prices[i - 1], 0);
            pre += make;
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int solution = solution(prices);
        System.out.println(solution);
    }
}
