package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: Yzy
 * @Date: 2021/9/12 10:27
 * @题解: 乘积最大子数组. 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Lc152 {
    public static int solution(int[] nums) {
        /**
         * dp定义：以i为结尾的最大连续子数组
         * 从里面找出最大的
         * 状态转移的过程（要考虑到符号变化导致的乘积变化）：
         * dp[i] = Math.max(dp[i-1]*nums[i],dpmin[i-1]*nums[i],nums[i])
         * dpmin[i] = Math.min(dp[i-1]*nums[i],dpmin[i-1]*nums[i],nums[i])
         * dp[0] = nums[0]
         */
        int premax = nums[0];
        int premin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = premax * nums[i];
            int min = premin * nums[i];
            premax = Math.max(Math.max(max, nums[i]), min);
            premin = Math.min(max, Math.min(min, nums[i]));
            res = Math.max(premax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8};
        int solution = solution(nums);
        System.out.println(solution);
    }

}
