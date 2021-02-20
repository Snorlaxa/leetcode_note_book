package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yzy
 * @Date: 2021/1/11 9:52
 *
 * 题意： 求两数组中和为target的下标
 *
 * 借助map，key-value含义分别为：
 * key：nums数字
 * value：下标
 * 遍历nums，用差作为key查找map，如果存在，说明有对应相加为target的值，返回下标即可
 * 如果没有，将当前值的差存入map，等待后续判断
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int n = target - nums[i];
            Integer res = map.get(n);
            if (res != null) {
                return new int[]{res, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;
        int[] ints = newInstance().twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static TwoSum newInstance() {
        return new TwoSum();
    }
}
