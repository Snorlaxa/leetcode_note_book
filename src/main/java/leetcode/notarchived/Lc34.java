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
         * 因为在求左边界的过程且目标值存在时，最后一轮一定有left=mid。因为如果left<mid, 目标又是存在的，下一轮就要跳出了，必然在这一轮能找到，
         * 所以mid=target，而将right:=mid-1会使得循环跳出，说明right<left，所以mid一定等于left。
         * 因为最后一轮left=mid=target,下一轮会查左边，right=mid-1，此时right必定小于target，所以需要选择left
         * 【  为什么right=mid-1必定小于target？因为边界不会在[left,mid]范围的左边。
         *    如[1=left,2,3,3=mid,3,4=right]这种情况，取值范围是左边left到mid（包含），[0,3]，
         *    即遇到mid=target时，左取值边界是不会移动的，
         *    这样就避免了边界在[left,mid]左边的情况，而right到了范围左边，必然小于target  】
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
