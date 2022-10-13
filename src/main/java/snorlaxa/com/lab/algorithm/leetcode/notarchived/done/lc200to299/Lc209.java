package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;

/**
 * 长度最小的子数组
 */
public class Lc209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum >= target) {
                sum -= nums[j];
                min = Math.min(i - j + 1, min);
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6};
        int i = minSubArrayLen(5, nums);
        System.out.println(i);
    }
}
