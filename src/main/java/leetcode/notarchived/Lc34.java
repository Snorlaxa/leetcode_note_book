package leetcode.notarchived;

import java.util.Arrays;

/**
 * @Author: 余子毅
 * @Date: 2021/5/17 9:41
 * @题意: 有序数组内部有重复数据，查找目标数据的开始位置和结束位置，[5,7,7,8,8,9] 找8=> [3,4]，不存在返回[-1,-1]
 * @题解: 二分查找，分别查找左右边界
 */
public class Lc34 {
    public static int[] solution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        // 左边界
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 可能是最左边，继续往左边查找
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 目标在右边，往右边查找
                left = mid + 1;
            } else {
                // 目标在左边，往左边查找
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        /**
         * 为什么是left？
         * 因为在求左边界的过程且目标值存在时，最后一轮有两种情况，一种是left=mid，下一轮会查左边，right=mid-1，此时right必定小于target，所以需要选择left
         * 【    为什么right=mid-1必定小于target？因为不会存在[left,mid]范围之外的target
         *      如果出现[1-left,2,3,3-mid,3,4-right]这种情况，取值范围是左边[0,3]，这样就避免了边界在[left,mid]之外的情况，
         *      而right到了范围之外，必然小于target  】；
         * 另一种情况是left<mid-1，则right=mid-1=left,相等，下一轮跳出。
         * 不可能存在mid=right的情况，因为mid=(left+right)/2。
         * 即无论怎么样，left都会是
         * 最后一轮，left与right只有重合或不重合两种情况，重合时，下一次移动left=right,right:=mid-1,则nums[right]将会小于target；
         * 不重合，则前一轮必定mid=left，最后一轮right:=mid-1，right<mid=left，跳出。若前一轮mid>left，不可能存在mid-1<left这种不重合的情况。
          */
        res[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 可能是最右边，继续往右边查找
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 目标在右边，往右边查找
                left = mid + 1;
            } else {
                // 目标在左边，往左边查找
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,9};
        int[] solution = solution(nums, 8);
        System.out.println(Arrays.toString(solution));
    }
}
