package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/28 22:44
 * @题意: 删除有序数组中的重复项 II.给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素最多出现两次，返回删除后数组的新长度。要求空间复杂度O(1)。
 */
public class Lc80 {
    public static int solution(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int count = 1, step = 0, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            if (current > 2) {
                step++;
            } else count++;

            nums[i - step] = nums[i];
        }
        return count;
    }

    public static int solution2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j < 2 || nums[j - 2] != nums[i])
                nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 3, 4};
        int len = solution2(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
