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

    /**
     * 分治法 复杂度O(nlogn)
     *
     * @param target 目标值
     * @param nums   数组
     * @return 长度
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        return minSubArrayLen(target, nums, 0, nums.length - 1);
    }

    private static int minSubArrayLen(int target, int[] nums, int left, int right) {
        if (left >= right) return 0;
        // 落在中间
        int x = left + right >> 1;
        int l = x, r = x + 1, midResult = 0;
        // 双指针向两边展开？还是向x靠拢
//        while (l >= left && r <= right) {
//            midResult += Math.max(nums[l], nums[r]);
//        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int i = minSubArrayLen(5, nums);
        System.out.println(i);
    }
}
