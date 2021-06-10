package leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:49
 * @题意: 组合总和二，在组合综合1的基础上增加了不使用重复数字的约束，并且参数可能会有重复，增加了去重的难度
 * @题解: 去重时，对结果排序会导致复杂度增加，而在原数据上做排序可以达到相同的效果
 * 题解2: 在叶子节点使用hash表去重会导致复杂度很高，因为本身dfs的复杂度就高，最好是在搜索过程中解决题目的所有约束操作。
 * <p>
 * 参考Lc39可以使用begin约束搜索过程不往回退且不使用相同的元素，
 * 但相比39该题的数据有重复，需要加入新的剪枝条件。
 * 所以新的问题是如何排除重复数据对搜索过程的影响。由于在排序后，
 * 相同数据的搜索过程是完全相同的，所以可以在同一层搜索内，
 * 第一个数据搜索结束后忽略后续相同的数据
 * </p>
 */
public class Lc40 {
    public static List<List<Integer>> solution(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int[] flags = new int[nums.length];
        dfs(res, flags, nums, target, 0);
        return new ArrayList<>(res);
    }

    private static void dfs(HashSet<List<Integer>> res, int[] flags, int[] nums, int target, int sum) {
        if (sum == target) {
            res.add(generate(flags, nums));
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] == 0 && sum + nums[i] <= target) {
                flags[i]++;
                sum += nums[i];
                dfs(res, flags, nums, target, sum);
                flags[i]--;
                sum -= nums[i];
            }
        }
    }

    private static List<Integer> generate(int[] flags, int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] > 0) res.add(nums[i]);
        }
        return res;
    }

    public static List<List<Integer>> solution2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs2(res, nums, target, new ArrayDeque<>(), 0);
        return new ArrayList<>(res);
    }

    public static void dfs2(List<List<Integer>> res, int[] nums, int target, Deque<Integer> deque, int begin) {
        if (target == 0) res.add(new ArrayList<>(deque));
        for (int i = begin; i < nums.length; i++) {
            // 排序数组，如果当前数据比目标大，后续的数据也比目标大
            if (target - nums[i] < 0) break;

            // 同一层第一个元素以后，相同元素需要去重
            if (i > begin && nums[i] == nums[i - 1]) continue;

            deque.addLast(nums[i]);
            target -= nums[i];
            dfs2(res, nums, target, deque, i + 1);
            target += nums[i];
            deque.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> solution = solution2(nums, 8);
        solution.forEach(x -> {
            x.forEach(y -> {
                System.out.print(y + " ");
            });
            System.out.println();
        });
    }
}
