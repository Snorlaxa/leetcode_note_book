package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;


/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class Lc300 {
    public static int lengthOfLIS(int[] nums) {
        /**
         * 动态规划
         * 定义dp[i]是以i为结尾的最长递增子序列长度
         */
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 找到前面最长的结果
            int max = 0;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i] && max < dp[j]) max = dp[j];
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    /**
     * 复杂度nlogn。贪心算法加上二分
     * @param nums 输入
     * @return 最长连续递增子序列长度
     */
    public static int lengthOfLIS2(int[] nums) {
        /**
         * 动态规划 改成logn复杂度
         * 定义dp[i]是长度为i+1的连续子序列的尾部元素值，这保证了dp是递增的
         */
        int[] tails = new int[nums.length];
        int result = 0;
        for (int num : nums) {
            // 以nums[i]为结尾的最长子序列，如果比当前存的更小，就替换存入，保持每个长度的结尾数字最小
            // 当有一个新的元素nums[k]时，如果前面长度从1到k的子序列里有比当前这个数大的，就把他换成nums[k]，这样后面接更长序列的概率就更大
            // 如果没有就新加入到tails，因为相当于nums[k]比前面任何一个都大，就可以与前面任意子序列形成连续递增子串

            int l = 0, r = result;
            while (l < r) {
                int mid = l + r >> 1;
                if (tails[mid] < num) {
                    // 在右边
                    l = mid + 1;
                } else {
                    // 大于等于，可能是当前数字或者左边
                    r = mid;
                }
            }
            tails[l] = num;
            // 如果是新增，result增加
            if (result == r) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[]{0, 1, 2, 3, 3, 3, 2}));
    }
}
