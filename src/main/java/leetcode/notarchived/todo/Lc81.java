package leetcode.notarchived.todo;

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
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return true;
            if (nums[0] < nums[mid]) {
                // mid在前半段
                if (nums[0] < target && target < nums[mid]) {
                    // target在mid前
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[0] > nums[mid]) {
                // mid在后半段
                if (nums[0] > target && nums[mid] < target) {
                    // target在mid后
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                // mid落在start位置
                if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        boolean solution = solution(nums, 2);
        System.out.println(solution ? '是' : '否');
    }
}
