package leetcode.array;

/**
 * @Author: Yzy
 * @Date: 2021/1/13 12:10
 * @题意: 求两升序数组中位数，要求复杂度O(log(m+n))
 * @思路1: 采用构造有序数组的方法，最小复杂度应该是O(m+n)，不符合log(m+n)的要求
 * @思路2: 对两个数组同时做二分，两个数组左边的数量之和与右边数量之和相同，且左边的任何一部分都比右边的任何一部分小，就能得到中位数的位置
 * 同理可以求第k大的数
 */
public class MedianOfTwoSortArrays {
    public static int solution(int[] nums1, int[] nums2) {
        int l1 = 0, r1 = nums1.length - 1, l2 = 0, r2 = nums2.length - 1;
        /**
         * 如何判断两边相等： 奇数+奇数，左边是
         * [1',4,5:,6,7"]
         * [1',2,3:,8,90"]
         */
        return 0;
    }
}