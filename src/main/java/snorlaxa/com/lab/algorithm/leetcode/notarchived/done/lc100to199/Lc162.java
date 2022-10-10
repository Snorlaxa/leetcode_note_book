package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

/**
 * @Author: Yzy
 * @Date: 2022/9/24 10:42
 * @题解: 峰值元素是指其值严格大于左右相邻值的元素。给你一个整数数组 nums，找到峰值元素并返回其索引,nums[-1] = nums[n] = -∞
 */
public class Lc162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int lv = mid <= 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rv = mid >= n - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] > lv && nums[mid] > rv) return mid;
            if (lv <= rv) {
                //向右移动
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
