package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;


/**
 * 寻找旋转排序数组中的最小值
 */
public class Lc153 {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[l]) {
                // 目标在右边
                r = mid;
            } else {
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{0,2}));
    }
}
