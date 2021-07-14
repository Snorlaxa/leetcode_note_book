package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.Arrays;

/**
 * @Author: 余子毅
 * @Date: 2021/5/10 13:41
 * @题意: 最接近的三数之和
 * @题解: 类似三数之和，不过加了最大距离筛选，不需要去重操作
 */
public class Lc16 {
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int constantNum = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = constantNum + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4,0,2,9};
        int solution = solution(nums, 1);
        System.out.println(solution);
    }
}
