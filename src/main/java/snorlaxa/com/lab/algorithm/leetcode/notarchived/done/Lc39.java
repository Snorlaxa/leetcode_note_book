package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:40
 * @题意: 组合总和, 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates = [2,3,6,7], target = 7
 * [
 * [7],
 * [2,2,3]
 * ]
 * @题解: 回溯剪枝，去重问题比较困难，剪枝的条件应该尽可能地考虑更多
 * @题解2: 由于使用hash去重太麻烦而且效率不高，尝试在搜索过程中直接去重。
 * <p>这类对搜索顺序无要求，认为相同数字不同顺序的数组为相同的问题，可以限定向深度探索时，不对当前已探索的最新元素以前的元素进行探索。</p>
 * <p>因为探索旧元素的路线是之前已经访问过的路线。如本题目中的223和232，在探索232中的节点3时，如果后续选择2，实际上是探索223时已经探
 * 索过的路径。为了避免这种路径，可以限定每次搜索的起始点，保证每次搜索都不往回走</p>
 */
public class Lc39 {
    /**
     * 解法1，使用hash去重，比较复杂，时间复杂度高
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution01(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        int[] flags = new int[nums.length];
        dfs(res, flags, nums, target, 0);
        return new ArrayList<>(res);
    }

    private static void dfs(HashSet<List<Integer>> res, int[] flags, int[] nums, int target, int sum) {
        if (sum == target) {
            res.add(generate(flags, nums));
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
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
            int t = flags[i];
            while (t-- > 0) res.add(nums[i]);
        }
        return res;
    }

    public static List<List<Integer>> solution02(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs2(res, candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    public static void dfs2(List<List<Integer>> res, int[] nums, int target, int begin, Deque<Integer> deque) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        // 约束同一分支搜索的元素不可重复来去重
        for (int i = begin; i < nums.length; i++) {
            // 已经排序好的数据，如果当前数据无法满足，后续的数据更大，更无法满足
            if (target < nums[i]) return;
            // 剪枝
            target -= nums[i];
            deque.addLast(nums[i]);
            dfs2(res, nums, target, i, deque);
            deque.removeLast();
            target += nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        List<List<Integer>> solution = solution02(nums, 2);
        solution.forEach(x -> {
            x.forEach(y -> {
                System.out.print(y + " ");
            });
            System.out.println();
        });
    }
}
