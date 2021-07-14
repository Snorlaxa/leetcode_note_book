package snorlaxa.com.lab.algorithm.leetcode.cataloged.dynamicProgramming;

/**
 * @Author: Yzy
 * @Date: 2021/1/19 11:45
 * @题意: 抢劫一排环形住户，但是不能抢邻近的住户，求最大抢劫量。
 * @题解: 考虑到住户是环形的，存在最后一个与第一个相邻的特殊情况，保证最后抢的两个住户不相邻的情况有两种：
 * 1. 抢第一个到倒数第二个范围内的住户（0 ~ n-2)
 * 2. 抢第二个到最后一个范围内的住户 （1 ~ n-1）
 * @总结： 将新的场景转变为已知的场景处理，或者说要有意识地去思考如何使用已知的场景解决新问题，寻找共通点，识别差异，寻求变通。
 */
public class HouseRobberII {
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private static int rob(int[] nums, int start, int end) {
        int first = 0, last = 0;
        for (int i = start; i <= end; i++) {
            int temp = first;
            first = last;
            last = Math.max(last, temp + nums[i]);
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 5};
        System.out.println(solution(nums));
    }
}
