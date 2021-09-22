package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/9/13 9:37
 * @题意: 打家劫舍。不能偷相邻的两家，求一条街能偷盗的最高金额
 */
public class Lc198 {
    public static int solution(int[] nums) {
        /**
         * dp[i]定义：在前i家能偷盗的最高金额
         * 状态的转移取决于是否偷第i家
         * dp[i] = max(dp[i-2]+nums[i],dp[i-1])
         * 边界条件：i=1，只有一家；i=2，取大的一家
         * 4 1 1 4
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
