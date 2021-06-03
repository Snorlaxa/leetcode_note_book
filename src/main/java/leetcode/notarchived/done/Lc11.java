package leetcode.notarchived.done;

/**
 * @Author: Yzy
 * @Date: 2021/4/15 16:00
 * @题意: 数组nums表示不同高度的墙，求哪两堵墙能蓄最多的水
 * @题解: 双指针法，向内收缩。由于距离缩短，要想蓄水更多，只能要求墙更高。蓄水多少又取决于最低的墙，于是两者中低的墙要移动以寻求更高的高度
 */
public class Lc11 {
    public static int solution(int[] nums) {
        int left = 0, right = nums.length - 1, max = Integer.MIN_VALUE;
        while (left < right) {
            int v = (right - left) * Math.min(nums[left], nums[right]);
            // 移动低的墙
            if (nums[left] > nums[right]) right--;
            else left++;
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(nums));
    }
}
