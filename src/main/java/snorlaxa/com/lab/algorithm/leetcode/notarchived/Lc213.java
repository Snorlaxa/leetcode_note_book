package snorlaxa.com.lab.algorithm.leetcode.notarchived;

public class Lc213 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int result1 = nums[0], result2;
        // 取第一个，求第2~n-1的最大值
        int dp0 = nums[2];
        int dp1 = n - 1 > 3 ? Math.max(nums[2], nums[3]) : nums[2];
        for (int i = 4; i < n - 1; i++) {
            int temp = dp1;
            dp1 = Math.max(dp0 + nums[i], dp1);
            dp0 = temp;
        }
        result1 += dp1;
        dp0 = nums[1];
        dp1 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int temp = dp1;
            dp1 = Math.max(dp0 + nums[i], dp1);
            dp0 = temp;
        }
        result2 = dp1;

        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
