package leetcode.notarchived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 余子毅
 * @Date: 2021/5/10 17:37
 * @题意: 三数之和，需要去重
 * @题解: 难点在于去重
 */
public class Lc15 {
    public static List<int[]> solution(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 过滤相同的起点
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    // 只需要对结果去重
                    // 过滤相同的left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 过滤相同的right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    res.add(new int[]{a, nums[left], nums[right]});
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, 0, 0, 2, 2, 2, 3, 4, 6, 6, 6, 6, 6};
        List<int[]> solution = solution(nums, 4);
        solution.forEach(x -> {
            String res = Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(","));
            System.out.println(res);
        });
    }
}
