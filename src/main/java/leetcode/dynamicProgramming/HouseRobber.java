package leetcode.dynamicProgramming;

/**
 * @Author: Yzy
 * @Date: 2021/1/19 11:45
 * @题意: 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 * @题解: 临近的住户不能抢，所以f(n)= Max(f(n-1),f(n-2)+num[n])
 */
public class HouseRobber {
    public static int solution(int[] nums) {
        //first = f(n-2), last = f(n-1)
        int first = 0, last = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = first;
            first = last;
            last = Math.max(last, temp + nums[i]);
        }
        return last;
    }

    public static void main(String[] args) {
        int [] nums = {3,4,1,5};
        System.out.println(solution(nums));
    }
}
