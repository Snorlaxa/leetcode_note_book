package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import java.util.Arrays;

/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/10/25 13:22
 * 167. 两数之和 II - 输入有序数组
 * 有重复数，非递减顺序，索引从1开始
 */
public class Lc167 {
    /**
     * 双指针法
     * 指针移动：如果和比目标大，移动右指针，比目标小移动左指针，大小相同的情况不会出现吧？
     *
     * @param numbers 数据
     * @param target  目标数
     * @return 索引
     */
    public static int[] solution(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 4};
        int[] res = solution(nums, 6);
        System.out.println(Arrays.toString(res));
    }
}
