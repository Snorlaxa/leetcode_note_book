package snorlaxa.com.lab.algorithm.leetcode.cataloged.array;

/**
 * @Author: Yzy
 * @Date: 2021/1/13 12:10
 * @题意: 求两升序数组中位数，要求复杂度O(log(m+n))
 * @思路1: 采用构造有序数组的方法，最小复杂度应该是O(m+n)，不符合log(m+n)的要求
 * @思路2: 求第k大，k=中位数位置，二分找切分点使得两数组左半边相加等于k;
 * 可简化为找一个短数组的切分点，另一个数组切分点的位置等于k-i.
 * 二分的移动策略是：A数组切分点的左部小于B切分点的右部，否则A切分点过大，左移；
 * B切分点的左部小于A切分点的右部，否则B切分点过大，即A切分点过小，右移。
 * @注意: 切分点代表着其左部的数据全部小于第k大的数据
 */
public class MedianOfTwoSortArrays {
    public static double solution(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return solution(nums2, nums1);
        }
        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, r = n1, k = (n1 + n2 + 1) / 2, mid1 = 0, mid2 = 0;
        /**
         * 左右指针相遇时也可能有解
         */
        while (l <= r) {
            mid1 = l + (r - l) / 2;
            mid2 = k - mid1;
            if (mid1 > 0 && nums1[mid1 - 1] > nums2[mid2]) {
                // A数组切分点过大，左移
                r = mid1 - 1;
            } else if (mid1 < n1 && nums2[mid2 - 1] > nums1[mid1]) {
                // B数组切分点过大，即A数组切分点过小，右移
                l = mid1 + 1;
            } else {
                //符合条件
                break;
            }
        }

        /**
         *
         * 判断中位数
         *
         * 找到切分点后有几种可能边界情况：
         * 1. 某个数组切分点为0。说明k个数全在另一个数组上，所以k在另一个数组左部的最后一个
         * 2. 某个数组切分点位置等于数组长度，即整个数组都在k之前，所以k在另一个数组右部第一个（前面都是小于第k大的）
         * 3. 若数组之和为奇数，则中位数等于两个数组左部的最后一个中较大的那个
         * 4. 若数组之和为偶数，中位数等于两数组左部最后一个中较大的那个，与两数组右部第一个中较小的那个，两者的平均
         *
         */
        int midLeft, midRight;
        if (mid1 == 0) {
            midLeft = nums2[mid2 - 1];
        } else if (mid2 == 0) {
            midLeft = nums1[mid1 - 1];
        } else {
            midLeft = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
        }
        if ((n1 + n2) % 2 == 1) {
            //奇数，以左部为准
            return midLeft;
        }
        // 偶数，计算右部
        if (mid1 == n1) {
            midRight = nums2[mid2];
        } else if (mid2 == n2) {
            midRight = nums1[mid1];
        } else {
            midRight = Math.min(nums1[mid1], nums2[mid2]);
        }

        System.out.println("mid1:" + mid1 + ",mid2:" + (k - mid1));
        return (midLeft + midRight) / 2.0D;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1};
        System.out.println(solution(nums1, nums2));
    }
}