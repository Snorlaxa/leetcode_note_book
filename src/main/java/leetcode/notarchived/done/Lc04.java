package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/23 20:49
 * @题意: 寻找两个正序数组的中位数。给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 要求时间复杂度O(log (m+n))
 * [1,2,4,5,6,7,8,10] [2,3,8,9,10,11]
 */
public class Lc04 {
    public static double solution(int[] nums1, int[] nums2) {
        // 保证nums1更长
        if (nums1.length < nums2.length) solution(nums2, nums1);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int k = l1 + l2 + 1 >> 1;
        // 相当于在两个数组中求第k大的数
        // 找一个边界，使得左边的数都小于两边界中较大者，且右边的数都大于该边界，且左边的数相加等于p
        // 定义c1为nums1前半段数组的边界，闭区间，定义c2为nums2前半段数组的边界，闭区间；
        int c1 = Math.min(l1, k) - 1;
        int c2 = k - c1 - 2;
        // 全在nums1，如果nums2右边有比nums1[c1]大的，要移动
        while (c2 < l2 - 1 && c1 >= 0 && nums2[c2 + 1] < nums1[c1]) {
            c1--;
            c2++;
        }
        if ((l1 + l2) % 2 == 0) {
            int left, right;
            if (c1 == l1 - 1) right = nums2[c2 + 1];
            else if (c2 == l2 - 1) right = nums1[c1 + 1];
            else right = Math.min(nums1[c1 + 1], nums2[c2 + 1]);

            if (c2 == -1) left = nums1[c1];
            else if (c1 == -1) left = nums2[c2];
            else left = Math.max(nums1[c1], nums2[c2]);

            return (right + left) / 2.0;
        } else {
            if (c1 < 0) return nums2[c2];
            else if (c2 < 0) return nums1[c1];
            else return Math.max(nums1[c1], nums2[c2]);
        }
    }

    public static void main(String[] args) {
        // 8
        int[] nums1 = new int[]{1,3};
//        int[] nums1 = new int[]{0, 0};
        // 2
        int[] nums2 = new int[]{2,7};
        System.out.println(solution(nums1, nums2));
    }
}
