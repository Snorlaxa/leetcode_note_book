package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/8/12 9:47
 * @题意: 只出现一次的数字 II。给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。要求时间复杂度O(n)，空间复杂度O(1)
 */
public class Lc137 {
    public static int solution(int[] nums) {
        int high = 0, low = 0;
        for (int num : nums) {
            low = low ^ num & ~high;
            high = high ^ num & ~low;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {8, 3, 3, 3, 4, 4, 4};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
