package leetcode.notarchived;

/**
 * @Author: Yzy
 * @Date: 2021/4/14 9:56
 * @题意: 最大子序和，求数组子序列之和中最大的值
 * @题解: 分治法可以做，但是有点绕，但是空间复杂度比动态规划低(O(log n))
 * 动态规划简便很多。假设已i-1结尾的连续子数组的最大和f(i-1)已知，则以i结尾的连续子数组的最大子序和为f(i)=max(f(i-1)+nums[i]),nums[i])
 * 即看f(i-1)的数据对当前数据i是否有益，如果前面是负数，加上前面的还会减少值，不如舍弃，只采用自己跌数据。
 */
public class Lc53 {

    /**
     * 分治法
     *
     * @param nums
     * @return
     */
    public static int solution01(int[] nums) {
        //构造递归
        return recursion(nums, 0, nums.length - 1);
    }

    public static int recursion(int[] nums, int left, int right) {
        // 终止条件
        if (left == right) {
            return nums[left];
        }
        // 计算mid
        int mid = (left + right) / 2;
        int maxLeft = recursion(nums, left, mid);/*左边结束点包括mid*/
        int maxRight = recursion(nums, mid + 1, right);/*右边起始点用的mid+1*/
        // 中间部分可能的最值
        int maxMid = midMax(nums, left, right);
        return Math.max(maxLeft, Math.max(maxRight, maxMid));
    }

    public static int midMax(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        int maxLeft = Integer.MIN_VALUE;
        int sumLeft = 0;
        //计算左边的最大和
        for (int i = mid; i >= left; i--) {
            sumLeft += nums[i];
            if (sumLeft > maxLeft) {
                maxLeft = sumLeft;
            }
        }
        //计算右边的最大和
        int maxRight = Integer.MIN_VALUE;
        int sumRight = 0;
        for (int i = mid + 1; i <= right; i++) {
            sumRight += nums[i];
            if (sumRight > maxRight) {
                maxRight = sumRight;
            }
        }
        //相加
        return maxLeft + maxRight;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int solution02(int[] nums) {
        int max = Integer.MIN_VALUE;
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            before = before > 0 ? before + nums[i] : nums[i];
            max = Math.max(before, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, -1, -5, 6, 7, 8, -9, 10};
        int res = solution01(nums);
        System.out.println("分治法:"+res);
        res = solution02(nums);
        System.out.println("动态规划:"+res);
    }
}
