package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 14:07
 * @题意: 搜索旋转数组2。数组中会有重复数据。返会是否存在目标值
 */
public class Lc81 {
    public static boolean solution(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums[0] == target) return true;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return true;

            if (nums[l] < nums[mid]) {
                // mid在前半段
                if (nums[l] <= target && target < nums[mid]) {
                    // target在mid前
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[l] > nums[mid]) {
                // mid在后半段
                if (nums[r] >= target && nums[mid] < target) {
                    // target在mid后
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }

        return false;
    }

    public static boolean solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {  //否则，去后半部分找
                    end = mid - 1;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        boolean solution = solution(nums, 0);
        System.out.println(solution ? '是' : '否');
    }
}
